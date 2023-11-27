package com.example.addtocart.Products;

import javafx.scene.image.Image;

public class Product {
    private int productID;
    private String name;
    private double price;
    private String image;

    public Product(int productID, String name, double price, String image) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getProductID(){
        return productID;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getImage() {
        return image;
    }

}

