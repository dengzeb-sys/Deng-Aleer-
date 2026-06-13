package com.example.myapplication;

public class Service {
    private String name;
    private double price;
    private String description;
    private int imageResource;

    public Service(String name, double price, String description, int imageResource) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageResource = imageResource;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public int getImageResource() { return imageResource; }
}
