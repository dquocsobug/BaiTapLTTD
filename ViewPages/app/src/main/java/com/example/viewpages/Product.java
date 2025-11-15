package com.example.viewpages;

public class Product {
    int image;
    String title;
    String price;
    String discount;
    int quantity;

    public Product(int image, String title, String price, String discount, int quantity) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
    }
}
