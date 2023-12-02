package com.example.addtocart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Map;
import java.util.ResourceBundle;

public class checkoutController implements Initializable {
    @FXML
    private TableView<Product> orderTable;
    @FXML
    private TableColumn<Product, Integer> tableAmount;
    @FXML
    private TableColumn<Product, String> tableItem;
    @FXML
    private TableColumn<Product, Double> tablePrice;
    @FXML
    private TextArea itemsTextArea;
    @FXML
    private TextField firstNameField, lastNameField, addressField, apartmentField, cityField, countryRegionField, stateField, zipCodeField, emailAddressField;
    @FXML
    private TextField cardNumberField, cardholderNameField, expiryDateField, cvcField;
    @FXML
    private Text totalText;
    @FXML
    private Button completeCheckoutButton;
    @FXML
    private Button returnToCartButton;
    private ObservableList<Product> tableData = null;
    private double total = 0;
    @FXML
    void completeCheckOut(MouseEvent event) {
        setupCheckoutButton();
    }

    @FXML
    void returnToCart(MouseEvent event) throws IOException {
        Stage stage = (Stage) returnToCartButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("cartMain.fxml"));
        stage.setTitle("Cart");
        stage.setScene(new Scene(root));
    }
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
    private void displayCheckoutDetails() {
        tableData = listData();
        if(tableData == null){
            return;
        }

        // Assuming Product class has a method getName() for item names
        tableItem.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Assuming Product class has a method getQuantity() that returns Integer for quantities
        tableAmount.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // Assuming Product class has a method getPrice() that returns Double for prices
        tablePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        orderTable.setItems(tableData);
        updateTotal();
    }

    private void setupCheckoutButton() {
            if (allFieldsFilled() && isValidPaymentDetails()) {
                showAlert("Checkout Completed", "Checkout is completed, thank you for shopping with us!");
                sendEmailReceipt();
            } else {
                showAlert("Error", "Please fill in all fields correctly.");
            }
    }

    private boolean allFieldsFilled() {
        return !isEmpty(firstNameField) &&
                !isEmpty(lastNameField) &&
                !isEmpty(addressField) &&
                !isEmpty(apartmentField) &&
                !isEmpty(cityField) &&
                !isEmpty(countryRegionField) &&
                !isEmpty(stateField) &&
                !isEmpty(zipCodeField) &&
                !isEmpty(emailAddressField) &&
                !isEmpty(cardNumberField) &&
                !isEmpty(cardholderNameField) &&
                !isEmpty(expiryDateField) &&
                !isEmpty(cvcField);
    }

    private boolean isEmpty(TextField field) {
        return field.getText().trim().isEmpty();
    }

    private boolean isValidPaymentDetails() {
        return cardNumberField.getText().length() == 16 &&
                expiryDateField.getText().length() == 5 &&
                cvcField.getText().length() == 3;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void updateTotal(){
        double dummy = 0;
        ObservableList<Product> items = orderTable.getItems();
        if(items.isEmpty()){
            totalText.setText(String.valueOf(dummy));
            return;
        }
        BigDecimal b = new BigDecimal(total);
        double d = b.doubleValue();
        totalText.setText(String.valueOf(d));
    }

    private void sendEmailReceipt() {
        String email = emailAddressField.getText();
        String receipt = itemsTextArea.getText() + "\nTotal: " + totalText.getText();
        // Email sending logic here, e.g., using JavaMail API
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayCheckoutDetails();

    }
}
