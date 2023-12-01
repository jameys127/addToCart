package com.example.addtocart;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class cardProductController implements Initializable {
    Product thisProduct = new Product("", 0, "", 0);

    @FXML
    private AnchorPane card_form;

    @FXML
    private Button productAddToCart;

    @FXML
    private ImageView productImage;

    @FXML
    private Label productName;

    @FXML
    private Label productPrice;

    @FXML
    private Spinner<Integer> spinner;

    private Alert alert;
    private SpinnerValueFactory<Integer> spin;
    public void howMany(){
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        spinner.setValueFactory(spin);
    }


    public void productData(String name, Double price, String image) throws FileNotFoundException {
        thisProduct.setName(name);
        thisProduct.setPrice(price);
        thisProduct.setImage(image);
        FileInputStream displayImage = new FileInputStream(image);
        Image donut = new Image(displayImage, 257, 146, false, true);
        productName.setText(name);
        productPrice.setText("$" + String.valueOf(price));
        productImage.setImage(donut);
    }
    @FXML
    void addItem(MouseEvent event) throws IOException {
        if(spinner.getValue() == 0){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Items!");
            alert.setHeaderText(null);
            alert.setContentText("Tried to add item with quantity zero! Please try again.");
            alert.showAndWait();
            return;
        }
        thisProduct.setQuantity(spinner.getValue());
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigbitedonuts", "root", "dinosaur1234");
            statement = connection.prepareStatement("INSERT INTO bigbitedonuts.order (name, price, quantity, image) VALUES (?, ?, ?, ?)");
            statement.setString(1, thisProduct.getName());
            statement.setDouble(2, thisProduct.getPrice());
            statement.setInt(3, thisProduct.getQuantity());
            statement.setString(4, thisProduct.getImage());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Added");
        alert.setHeaderText(null);
        alert.setContentText("Successfully Added!");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        howMany();
    }
}
