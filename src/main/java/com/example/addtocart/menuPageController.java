package com.example.addtocart;

import com.example.addtocart.Products.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
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
    private int column = 0;
    private int row = 0;
    private int column1 = 0;
    private int row1 = 0;
    private int column2 = 0;
    private int row2 = 0;

    @FXML
    private Button breakfastMenuButton;

    @FXML
    private Button donutMenuButton;

    @FXML
    private Button drinkMenuButton;

    @FXML
    private ScrollPane breakfastMenuPane;

    @FXML
    private ScrollPane donutMenuPane;

    @FXML
    private ScrollPane drinkMenuPane;

    @FXML
    private Button home;

    @FXML
    private GridPane productGridBreakfast;

    @FXML
    private GridPane productGridDonuts;

    @FXML
    private GridPane productGridDrinks;

    @FXML
    void breakfastVisible(MouseEvent event) {
        breakfastMenuPane.setVisible(true);
        donutMenuPane.setVisible(false);
        drinkMenuPane.setVisible(false);
    }

    @FXML
    void donutVisible(MouseEvent event) {
        breakfastMenuPane.setVisible(false);
        donutMenuPane.setVisible(true);
        drinkMenuPane.setVisible(false);
    }

    @FXML
    void drinkVisible(MouseEvent event) {
        breakfastMenuPane.setVisible(false);
        donutMenuPane.setVisible(false);
        drinkMenuPane.setVisible(true);
    }


    @FXML
    void homeButton(MouseEvent event) throws IOException {
        Stage stage = (Stage) home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage.setTitle("Menu");
        stage.setScene(new Scene(root));

    }
    @FXML
    void signOutButton(MouseEvent event) throws IOException {
        Stage stage = (Stage) home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
        stage.setTitle("Log In");
        stage.setScene(new Scene(root));
    }

    Product pinkSprink = new Product("Pink Sprinkled Donut", 2.99, pinkSprinkImage);


    public void menuDisplayDonut(String name, Double price, String image){
        productGridDonuts.getColumnConstraints().clear();
        productGridDonuts.getRowConstraints().clear();

        try{
            FXMLLoader load = new FXMLLoader();
            load.setLocation(getClass().getResource("cardProduct.fxml"));
            AnchorPane pane = load.load();
            cardProductController cardCont = load.getController();
            cardCont.productData(name, price, image);


            if (column == 3) {
                column = 0;
                row += 1;
            }

            productGridDonuts.add(pane, column++, row);
            GridPane.setMargin(pane, new Insets(10));



        }catch(Exception e){
            e.printStackTrace();
        }


    }

    public void menuDisplayBreakfast(String name, Double price, String image){
        productGridBreakfast.getColumnConstraints().clear();
        productGridBreakfast.getRowConstraints().clear();

        try{
            FXMLLoader load = new FXMLLoader();
            load.setLocation(getClass().getResource("cardProduct.fxml"));
            AnchorPane pane = load.load();
            cardProductController cardCont = load.getController();
            cardCont.productData(name, price, image);


            if (column1 == 3) {
                column1 = 0;
                row1 += 1;
            }

            productGridBreakfast.add(pane, column1++, row1);
            GridPane.setMargin(pane, new Insets(10));



        }catch(Exception e){
            e.printStackTrace();
        }


    }

    public void menuDisplayDrinks(String name, Double price, String image){
        productGridDrinks.getColumnConstraints().clear();
        productGridDrinks.getRowConstraints().clear();

        try{
            FXMLLoader load = new FXMLLoader();
            load.setLocation(getClass().getResource("cardProduct.fxml"));
            AnchorPane pane = load.load();
            cardProductController cardCont = load.getController();
            cardCont.productData(name, price, image);

            if (column2 == 3) {
                column2 = 0;
                row2 += 1;
            }

            productGridDrinks.add(pane, column2++, row2);
            GridPane.setMargin(pane, new Insets(10));

        }catch(Exception e){
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuDisplayDonut(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDonut(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDonut(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDonut(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDonut(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDonut(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDonut(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDonut(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDonut(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());



        menuDisplayBreakfast(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayBreakfast(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayBreakfast(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayBreakfast(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayBreakfast(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayBreakfast(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayBreakfast(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayBreakfast(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayBreakfast(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayBreakfast(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());



        menuDisplayDrinks(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDrinks(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDrinks(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDrinks(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDrinks(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDrinks(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDrinks(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDrinks(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());

    }
}
