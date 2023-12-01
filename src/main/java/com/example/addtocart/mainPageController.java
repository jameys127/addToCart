package com.example.addtocart;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class mainPageController {

    @FXML
    private Button menu;

    @FXML
    private Button signout;


    @FXML
    void menuButton(MouseEvent event) throws IOException {
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        stage.setTitle("Menu");
        stage.setScene(new Scene(root));
    }

    @FXML
    void signoutButton(MouseEvent event) throws IOException {
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
        stage.setTitle("Log In");
        stage.setScene(new Scene(root));
    }

}
