package com.example.addtocart;

import com.example.addtocart.Products.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.*;
import java.util.stream.Collectors;

public class menuPageController implements Initializable {

    String pinkSprinkImage = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\chocolateoldfashioned.jpeg";
    private int column = 0;
    private int row = 0;
    private int column1 = 0;
    private int row1 = 0;
    private int column2 = 0;
    private int row2 = 0;
    private int column3 = 0;
    private int row3 = 0;

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
    private ScrollPane searchMenuPane;

    @FXML
    private Label noResults;

    @FXML
    private Button home;

    @FXML
    private GridPane productGridBreakfast;

    @FXML
    private GridPane productGridDonuts;

    @FXML
    private GridPane productGridDrinks;

    @FXML
    private GridPane productGridSearch;

    @FXML
    private TextField searchBar;

    @FXML
    void searchbarButton(MouseEvent event) {
        int displayed = 0;
        noResults.setVisible(false);
        column3 = 0;
        row3 = 0;
        productGridSearch.getChildren().clear();
        List<Product> products = new ArrayList<Product>();
        Collections.addAll(products, pinkSprink, pinkSprink1, pinkSprink2, pinkSprink3, pinkSprink4, pinkSprink5, pinkSprink6, pinkSprink7);
        List<String> productNames = searchProducts(searchBar.getText(), products);
        for(Product obj : products){
            if(productNames.contains(obj.getName())){
                menuDisplaySearch(obj.getName(), obj.getPrice(), obj.getImage());
                displayed++;
            }
        }
        breakfastMenuPane.setVisible(false);
        donutMenuPane.setVisible(false);
        drinkMenuPane.setVisible(false);
        searchMenuPane.setVisible(true);
        if(displayed == 0){
            noResults.setVisible(true);
        }
    }

    private List<String> searchProducts(String searchWords, List<Product> products){
        List<String> trimmedWords = Arrays.asList(searchWords.trim().split(" "));
        List<String> getNames = products.stream().map(input -> input.getName()).collect(Collectors.toList());
        return getNames.stream().filter(input -> {
            return trimmedWords.stream().allMatch(words ->
                    input.toLowerCase().contains(words.toLowerCase()));
        }).collect(Collectors.toList());
    }


    @FXML
    void breakfastVisible(MouseEvent event) {
        breakfastMenuPane.setVisible(true);
        donutMenuPane.setVisible(false);
        drinkMenuPane.setVisible(false);
        searchMenuPane.setVisible(false);
    }

    @FXML
    void donutVisible(MouseEvent event) {
        breakfastMenuPane.setVisible(false);
        donutMenuPane.setVisible(true);
        drinkMenuPane.setVisible(false);
        searchMenuPane.setVisible(false);
    }

    @FXML
    void drinkVisible(MouseEvent event) {
        breakfastMenuPane.setVisible(false);
        donutMenuPane.setVisible(false);
        drinkMenuPane.setVisible(true);
        searchMenuPane.setVisible(false);
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

    Product pinkSprink = new Product(1, "Pink Sprinkled Donut", 2.99, pinkSprinkImage);
    Product pinkSprink1 = new Product(2, "Yellow Sprinkled Donut", 2.99, pinkSprinkImage);
    Product pinkSprink2 = new Product(3, "Green Sprinkled Donut", 2.99, pinkSprinkImage);
    Product pinkSprink3 = new Product(4, "Blue Sprinkled Donut", 2.99, pinkSprinkImage);
    Product pinkSprink4 = new Product(5, "Red Sprinkled Donut", 2.99, pinkSprinkImage);
    Product pinkSprink5 = new Product(6, "Purple Sprinkled Donut", 2.99, pinkSprinkImage);
    Product pinkSprink6 = new Product(7, "Orange Sprinkled Donut", 2.99, pinkSprinkImage);
    Product pinkSprink7 = new Product(8, "Teal Sprinkled Donut", 2.99, pinkSprinkImage);

    public void menuDisplaySearch(String name, Double price, String image) {
        productGridSearch.getColumnConstraints().clear();
        productGridSearch.getRowConstraints().clear();

        try {
            FXMLLoader load = new FXMLLoader();
            load.setLocation(getClass().getResource("cardProduct.fxml"));
            AnchorPane pane = load.load();
            cardProductController cardCont = load.getController();
            cardCont.productData(name, price, image);


            if (column3 == 3) {
                column3 = 0;
                row3 += 1;
            }

            productGridSearch.add(pane, column3++, row3);
            GridPane.setMargin(pane, new Insets(10));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        menuDisplayDonut(pinkSprink1.getName(), pinkSprink1.getPrice(), pinkSprink1.getImage());
        menuDisplayDonut(pinkSprink2.getName(), pinkSprink2.getPrice(), pinkSprink2.getImage());
        menuDisplayDonut(pinkSprink3.getName(), pinkSprink3.getPrice(), pinkSprink3.getImage());
        menuDisplayDonut(pinkSprink4.getName(), pinkSprink4.getPrice(), pinkSprink4.getImage());
        menuDisplayDonut(pinkSprink5.getName(), pinkSprink5.getPrice(), pinkSprink5.getImage());
        menuDisplayDonut(pinkSprink6.getName(), pinkSprink6.getPrice(), pinkSprink6.getImage());
        menuDisplayDonut(pinkSprink7.getName(), pinkSprink7.getPrice(), pinkSprink7.getImage());
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
