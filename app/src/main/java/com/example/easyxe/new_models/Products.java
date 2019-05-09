package com.example.easyxe.new_models;

public class Products {
    private String pname, description, pphonecontact, address, price, image, category, pid, data, time;

    public Products() {
    }

    public Products(String pname, String description, String pphonecontact, String address, String price, String image, String category, String pid, String data, String time) {
        this.pname = pname;
        this.description = description;
        this.pphonecontact = pphonecontact;
        this.address = address;
        this.price = price;
        this.image = image;
        this.category = category;
        this.pid = pid;
        this.data = data;
        this.time = time;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPphonecontact() {
        return pphonecontact;
    }

    public void setPphonecontact(String pphonecontact) {
        this.pphonecontact = pphonecontact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

