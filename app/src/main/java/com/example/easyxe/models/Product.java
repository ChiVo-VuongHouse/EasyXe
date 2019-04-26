package com.example.easyxe.models;

public class Product {
    private int id;
    private String name;
    private Double price;
    private String location;
    private String seller;
    private int image;

    public Product(int id, String name, Double price, String location, String seller, int image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.location = location;
        this.seller = seller;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return location + " | " +price +" đ";
    }
}
