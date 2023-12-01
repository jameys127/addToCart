package com.example.addtocart;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class cartController implements Initializable {
    @FXML
    private TableView<Product> cartTableView; // Updated to TableView
    @FXML
    private TableColumn<Product, String> cart_col_item; // Assuming this is for item names
    @FXML
    private TableColumn<Product, Integer> cart_col_amount; // Assuming this is for quantities
    @FXML
    private TableColumn<Product, Double> cart_col_price; // Assuming this is for item prices
    @FXML
    private Label subtotalLabel;
    @FXML
    private Button menu_btn;
    private ObservableList<Product> tableData = null;
    private double total = 0;

//    private CartData cartData;

//    public CartController() {
//        this.cartData = new CartData();
//    }

//    public void addItemToCart(Product product) {
//        cartData.addItem(product);
//        updateCartView();
//    }

    public ObservableList<Product> listData(){
        ObservableList<Product> dummy = FXCollections.observableArrayList();
        Product product = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigbitedonuts", "root", "dinosaur1234");
            statement = connection.prepareStatement("SELECT * FROM bigbitedonuts.order");
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                product = new Product(resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("image"),
                        resultSet.getInt("quantity"));
                dummy.add(product);
                total = total + resultSet.getDouble("price") * resultSet.getInt("quantity");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dummy;
    }
    private void updateCartView() {
        tableData = listData();
        if(tableData == null){
            return;
        }

        // Assuming Product class has a method getName() for item names
        cart_col_item.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Assuming Product class has a method getQuantity() that returns Integer for quantities
        cart_col_amount.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // Assuming Product class has a method getPrice() that returns Double for prices
        cart_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        cartTableView.setItems(tableData);
        updateSubtotal();
    }
    @FXML
    void toMenu(MouseEvent event) throws IOException {
        Stage stage = (Stage) menu_btn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        stage.setTitle("Menu");
        stage.setScene(new Scene(root));
    }

    @FXML
    void deleteRow(MouseEvent event) {
        Connection connection = null;
        PreparedStatement statement = null;
        Product product = cartTableView.getSelectionModel().getSelectedItem();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigbitedonuts", "root", "dinosaur1234");
            statement = connection.prepareStatement("DELETE FROM bigbitedonuts.order WHERE name = ?");
            statement.setString(1, product.getName());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        total = total - (product.getPrice() * product.getQuantity());
        cartTableView.getItems().removeAll(
                cartTableView.getSelectionModel().getSelectedItems()
        );
        updateSubtotal();
    }


    private void updateSubtotal() {
        double dummy = 0;
        ObservableList<Product> items = cartTableView.getItems();
        if(items.isEmpty()){
            subtotalLabel.setText(String.valueOf(dummy));
            return;
        }
        BigDecimal b = new BigDecimal(total);
        double d = b.doubleValue();
        subtotalLabel.setText(String.valueOf(d));
    }

    public void switchToCheckoutScene(ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Checkout.fxml"));
//            Parent checkoutRoot = loader.load();
//
//            CheckoutController checkoutController = loader.getController();
//             Assuming you have a mechanism to create or obtain a Checkout object
//            Checkout checkout = new Checkout(cartData);
//            checkoutController.setCheckoutData(checkout); // Set the checkout data here
//
//            Scene checkoutScene = new Scene(checkoutRoot);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setScene(checkoutScene);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCartView();
    }
}
