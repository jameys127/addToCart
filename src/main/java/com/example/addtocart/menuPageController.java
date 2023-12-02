package com.example.addtocart;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.*;
import java.util.stream.Collectors;

public class menuPageController implements Initializable {

    String pinkSprinkImage = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\Simpsons-Doughnuts-4238-Copy-1.jpg";
    String chocolateOldFashioned = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\chocolateoldfashioned.jpeg";
    String oldFashioned = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\donut-blog-3.jpg";
    String jellyDonut = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\1200px-Jelly-Donut.jpg";
    String mapleBar = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\Maple-Bar-Donuts1-scaled.jpg";
    String appleFritter = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\Apple-Fritters-DSC_0145-4.jpg";
    String eclair = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\french-chocolate-eclairs-recipe.jpg";
    String glazedDonut = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\PSOG_Image.jpg";
    String donutHoles = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\20150608-P6080031.jpg";
    String coffee = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\classic-coffee-1536922351-4302729.jpeg";
    String caramel = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\caramellatte.jpg";
    String vanilla = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\Vanilla_Latte.jpg";
    String orange = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\minuteMaidOrangeJuice.png";
    String cappuciii = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\1200px-Cappuccino_at_Sightglass_Coffee.jpg";
    String decafcoffee = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\5-Unexpected-Side-Effects-Of-Decaf-Coffee-You-Must-Be-Aware-Of.jpg";
    String bottledmilk = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\HDPE-Milk-1L.jpg";
    String hotchocky = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\Indulgent-Hot-Chocolate-FT-RECIPE0223-fd36942ef266417ab40440374fc76a15.jpg";
    String bagelbreakfast = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\bagel418907.jpeg";
    String burrito = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\breakfastburitto69134t1.jpeg";
    String egg = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\breakfast-egg-sandwich-recipe-9.jpg";
    String muffin = "C:\\Users\\jamey\\IdeaProjects\\addToCart\\src\\main\\resources\\assets\\chocolate-chip-muffins-featured.jpg";



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
    private Button cart;

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
        Collections.addAll(products, pinkSprink, chocolateoldFashioned, oldfashoned, jellydonut, ecclair, applefritter, glazed, donutholes, maple,
                                     brewedcoffee, decaf, caramellatte, vanillalatte, cappuccino, hotChocolate, milk, orangejuice,
                                     bagel, breakfastburrito, eggsandwich, chocolatemuffin);
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
    void cartButton(MouseEvent event) throws IOException {
        Stage stage = (Stage) cart.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("cartMain.fxml"));
        stage.setTitle("Cart");
        stage.setScene(new Scene(root));
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
    Product bagel = new Product("Bagel with Cream Cheese", 2.50, bagelbreakfast, 0);
    Product breakfastburrito = new Product("Breakfast Burrito", 5.65, burrito, 0);
    Product eggsandwich = new Product("Egg Sandwich", 2.50, egg, 0);
    Product chocolatemuffin = new Product("Chocolate Muffin", 2.15, muffin, 0);
    Product brewedcoffee = new Product("Classic Brewed Coffee", 3.50, coffee, 0);
    Product caramellatte = new Product("Iced Caramel Latte", 6.25, caramel, 0);
    Product vanillalatte = new Product("Vanilla Latte", 6.25, vanilla, 0);
    Product orangejuice = new Product("Minute Maid Orange Juice", 1.50, orange, 0);
    Product decaf = new Product("Classic Decaf coffee", 3.50, decafcoffee, 0);
    Product cappuccino = new Product("Cappuccino", 6.75, cappuciii, 0);
    Product milk = new Product("Bottled Milk", 1.50, bottledmilk, 0);
    Product hotChocolate = new Product("Hot Chocolate", 3.19, hotchocky, 0);
    Product pinkSprink = new Product("Pink Sprinkled Donut", 2.99, pinkSprinkImage, 0);
    Product chocolateoldFashioned = new Product("Chocolate Old Fashioned", 3.99, chocolateOldFashioned, 0);
    Product oldfashoned = new Product("Glazed Old Fashioned", 3.99, oldFashioned, 0);
    Product jellydonut = new Product("Jelly Filled Donut", 3.99, jellyDonut, 0);
    Product ecclair = new Product("Chocolate Eclair", 4.99, eclair, 0);
    Product applefritter = new Product("Apple Fritter", 4.99, appleFritter, 0);
    Product glazed = new Product("Glazed Donut", 1.99, glazedDonut, 0);
    Product donutholes = new Product("4-piece Donut Holes", 3.99, donutHoles, 0);
    Product maple = new Product("Maple Bar", 4.99, mapleBar, 0);

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

        menuDisplayDonut(glazed.getName(), glazed.getPrice(), glazed.getImage());
        menuDisplayDonut(pinkSprink.getName(), pinkSprink.getPrice(), pinkSprink.getImage());
        menuDisplayDonut(oldfashoned.getName(), oldfashoned.getPrice(), oldfashoned.getImage());
        menuDisplayDonut(chocolateoldFashioned.getName(), chocolateoldFashioned.getPrice(), chocolateoldFashioned.getImage());
        menuDisplayDonut(jellydonut.getName(), jellydonut.getPrice(), jellydonut.getImage());
        menuDisplayDonut(applefritter.getName(), applefritter.getPrice(), applefritter.getImage());
        menuDisplayDonut(ecclair.getName(), ecclair.getPrice(), ecclair.getImage());
        menuDisplayDonut(maple.getName(), maple.getPrice(), maple.getImage());
        menuDisplayDonut(donutholes.getName(), donutholes.getPrice(), donutholes.getImage());


        menuDisplayBreakfast(bagel.getName(), bagel.getPrice(), bagel.getImage());
        menuDisplayBreakfast(breakfastburrito.getName(), breakfastburrito.getPrice(), breakfastburrito.getImage());
        menuDisplayBreakfast(eggsandwich.getName(), eggsandwich.getPrice(), eggsandwich.getImage());
        menuDisplayBreakfast(chocolatemuffin.getName(), chocolatemuffin.getPrice(), chocolatemuffin.getImage());



        menuDisplayDrinks(brewedcoffee.getName(), brewedcoffee.getPrice(), brewedcoffee.getImage());
        menuDisplayDrinks(decaf.getName(), decaf.getPrice(), decaf.getImage());
        menuDisplayDrinks(caramellatte.getName(), caramellatte.getPrice(), caramellatte.getImage());
        menuDisplayDrinks(vanillalatte.getName(), vanillalatte.getPrice(), vanillalatte.getImage());
        menuDisplayDrinks(cappuccino.getName(), cappuccino.getPrice(), cappuccino.getImage());
        menuDisplayDrinks(hotChocolate.getName(), hotChocolate.getPrice(), hotChocolate.getImage());
        menuDisplayDrinks(milk.getName(), milk.getPrice(), milk.getImage());
        menuDisplayDrinks(orangejuice.getName(), orangejuice.getPrice(), orangejuice.getImage());

    }
}
