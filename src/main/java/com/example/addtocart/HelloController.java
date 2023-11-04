package com.example.addtocart;

import com.example.addtocart.Products.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;

import java.sql.*;

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
    private Label data_pass;

    @FXML
    private Label data_user;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    void createUsPas(MouseEvent event) throws SQLException {
        signup(event, username.getText(), password.getText());
        data_user.setText(getuser());
    }



    @FXML
    void getProducts(MouseEvent event) {
        if(Products.getSelectionModel().getSelectedItem() == "Pink Sprinkles"){
            Product donut = new Product("Pink Sprinkles",
                    "Pink Frosting with Rainbow Sprinkles.",
                    4.25);
            pinkSprinkName.setText(donut.getName());
            pinkSprinkDesc.setText(donut.getDesc());
        }
        if(Products.getSelectionModel().getSelectedItem() == "Maple Bar"){
            Product donut2 = new Product("Maple Bar",
                    "Longer donut with maple top and choice of filling.",
                    3.25);
            pinkSprinkName.setText(donut2.getName());
            pinkSprinkDesc.setText(donut2.getDesc());
        }
    }



    public static void signup(MouseEvent event, String username, String password){
        Connection connection = null;
        PreparedStatement psInsert = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigbitedonuts", "root", "dinosaur1234");
            psInsert = connection.prepareStatement("insert into users (username, pass) values (?, ?)");
            psInsert.setString(1, username);
            psInsert.setString(2, password);
            psInsert.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public static String getuser() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigbitedonuts", "root", "dinosaur1234");
            preparedStatement = connection.prepareStatement("select username from users");
            resultSet = preparedStatement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        while(resultSet.next()) {
            String retrieveUsername = resultSet.getString("username");
            return retrieveUsername;
        }
        return null;
    }

//    public void signupLabel(ActionEvent event, String username, String password) throws SQLException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        try{
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigbitedonuts", "root", "dinosaur1234");
//            preparedStatement = connection.prepareStatement("select username, pass from users");
//            resultSet = preparedStatement.executeQuery();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        while(resultSet.next()){
//            String retrievedUsername = resultSet.getString("username");
//            String retrievedPassword = resultSet.getString("pass");
//            data_user.setText(retrievedUsername);
//            data_pass.setText(retrievedPassword);
//
//        }
//
//    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Products.getItems().addAll("Pink Sprinkles", "Maple Bar");
    }
}