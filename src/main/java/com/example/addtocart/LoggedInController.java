package com.example.addtocart;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {
    @FXML
    private Button button_logout;

    @FXML
    private Label label_welcome;

    @FXML
    private Label label_fav_donut_shop;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                DBUtils.changeScene(event, "Sample.fxml", "Log in!", null, null);
            }
        });

    }

    public void setUserInformation(String username, String faveDonutShop) {

        label_welcome.setText("Welcome " + username + "!");
        label_fav_donut_shop.setText("Your Favorite Donut Shop is " + faveDonutShop + "!");

    }
}
