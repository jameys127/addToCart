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
    private Button b1g50off;

    @FXML
    private Button b2g1;

    @FXML
    private Button menu;

    @FXML
    private Button search;

    @FXML
    private TextField searchBar;

    @FXML
    private Button signout;

    @FXML
    void b1g50offButton(MouseEvent event) {

    }

    @FXML
    void b2g1Button(MouseEvent event) {

    }

    @FXML
    void menuButton(MouseEvent event) throws IOException {
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        stage.setTitle("Menu");
        stage.setScene(new Scene(root));


    }

    @FXML
    void searchbarButton(MouseEvent event) {

    }

    @FXML
    void signoutButton(MouseEvent event) {

    }
}
