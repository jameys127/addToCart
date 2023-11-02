package com.example.addtocart;

import com.example.addtocart.Products.Product;
import com.example.addtocart.Products.mapleBar;
import com.example.addtocart.Products.pinkSprinkles;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ChoiceBox<String> Products;

    @FXML
    private Label pinkSprinkDesc;

    @FXML
    private Label pinkSprinkName;


    @FXML
    void getProducts(MouseEvent event) {
        if(Products.getSelectionModel().getSelectedItem() == "Pink Sprinkles"){
            Product donut = new pinkSprinkles("Pink Sprinkles",
                    "Pink Frosting with Rainbow Sprinkles.",
                    4.25);
            pinkSprinkName.setText(donut.getName());
            pinkSprinkDesc.setText(donut.getDesc());
        }
        if(Products.getSelectionModel().getSelectedItem() == "Maple Bar"){
            Product donut2 = new mapleBar("Maple Bar",
                    "Longer donut with maple top and choice of filling.",
                    3.25);
            pinkSprinkName.setText(donut2.getName());
            pinkSprinkDesc.setText(donut2.getDesc());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Products.getItems().addAll("Pink Sprinkles", "Maple Bar");
    }
}