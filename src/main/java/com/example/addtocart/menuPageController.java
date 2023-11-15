package com.example.addtocart;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class menuPageController {
    @FXML
    private Button home;

    @FXML
    void homeButton(MouseEvent event) throws IOException {
        Stage stage = (Stage) home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage.setTitle("Menu");
        stage.setScene(new Scene(root));

    }
}
