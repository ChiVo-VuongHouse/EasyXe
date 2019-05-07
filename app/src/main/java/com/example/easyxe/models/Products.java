package com.example.easyxe.models;

public class Products {
   private int imageProduct;
   private String nameProduct;
   private int price;

    public Products(int imageProduct, String nameProduct, int price) {
        this.imageProduct = imageProduct;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public int getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(int imageProduct) {
        this.imageProduct = imageProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
