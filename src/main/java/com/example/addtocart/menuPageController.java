package com.example.addtocart;

import com.example.addtocart.Products.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class menuPageController implements Initializable {

    String pinkSprinkImage = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\chocolateoldfashioned.jpeg";

    private int row = 0;
    private int column = 0;

    @FXML
    private Button home;

    @FXML
    private GridPane productGrid;



    @FXML
    void homeButton(MouseEvent event) throws IOException {
        Stage stage = (Stage) home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage.setTitle("Menu");
        stage.setScene(new Scene(root));

    }

    Product pinkSprink = new Product("Pink Sprinkled Donut", 2.99, pinkSprinkImage);


    public void menuDisplay(String name, Double price, String image){
        productGrid.getRowConstraints().clear();
        productGrid.getColumnConstraints().clear();

        try{
            FXMLLoader load = new FXMLLoader();
            load.setLocation(getClass().getResource("cardProduct.fxml"));
            AnchorPane pane = load.load();
            cardProductController cardCont = load.getController();
            cardCont.productData(name, price, image);


            if (column == 4) {
                column = 0;
                row += 1;
            }

            productGrid.add(pane, column++, row);
            GridPane.setMargin(pane, new Insets(10));



        }catch(Exception e){
            e.printStackTrace();
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuDisplay(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplay(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplay(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplay(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplay(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplay(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplay(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());

//        menuDisplay();
//        menuDisplay();
//        menuDisplay();
//        menuDisplay();
//        menuDisplay();
//        menuDisplay();
//        menuDisplay();
//        menuDisplay();
//        menuDisplay();
//        menuDisplay();
//        menuDisplay();
//        menuDisplay();
//        menuDisplay();


    }
}
