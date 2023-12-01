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
import java.net.URL;
import java.util.ResourceBundle;

public class cardProductController implements Initializable {
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
        FileInputStream displayImage = new FileInputStream(image);
        Image donut = new Image(displayImage, 257, 146, false, true);
        productName.setText(name);
        productPrice.setText("$" + String.valueOf(price));
        productImage.setImage(donut);

    }
    @FXML
    void addItem(MouseEvent event) {
        if(spinner.getValue() == 0){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nothing was added!");
            alert.setHeaderText(null);
            alert.setContentText("You added a product with zero quantity! Try again.");
            alert.showAndWait();
            return;
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
