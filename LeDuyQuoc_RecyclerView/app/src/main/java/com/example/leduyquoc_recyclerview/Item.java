package com.example.leduyquoc_recyclerview;

public class Item {
    private String title;
    private int iconResId;
    private double price;
    private double discountPrice;
    private int quantity;

    public Item(String title, int iconResId, double price, double discountPrice, int quantity) {
        this.title = title;
        this.iconResId = iconResId;
        this.price = price;
        this.discountPrice = discountPrice;
        this.quantity = quantity;
    }

    public String getTitle() { return title; }
    public int getIconResId() { return iconResId; }
    public double getPrice() { return price; }
    public double getDiscountPrice() { return discountPrice; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalPrice() {
        return discountPrice * quantity;
    }
}
