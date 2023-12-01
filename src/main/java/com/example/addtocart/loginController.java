package com.example.addtocart;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @FXML
    private Button button_login;
    @FXML
    private Button button_sign_up;

    @FXML
    private TextField tf_username;

    @FXML
    private TextField tf_password;

    public void deleteCartContents(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigbitedonuts", "root", "dinosaur1234");
            statement = connection.prepareStatement("DELETE FROM bigbitedonuts.order");
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deleteCartContents();
        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.logInUser(event, tf_username.getText(), tf_password.getText());
            }
        });

        button_sign_up.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "sign-up.fxml", "Sign Up!", null, null);
            }
        });

    }
}
