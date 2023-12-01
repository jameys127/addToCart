package com.example.addtocart;

import javafx.scene.image.Image;

public class Product {

    private String name;
    private double price;
    private String image;
    private int quantity;

    public Product(String name, double price, String image, int quantity) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
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
    public int getQuantity(){
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

