package com.example.easyxe.models;

public class Followings {
    private int imageFollowiings;
    private String followingsName;
    private String address;

    public Followings(int imageFollowiings, String followingsName, String address) {
        this.imageFollowiings = imageFollowiings;
        this.followingsName = followingsName;
        this.address = address;
    }

    public int getImageFollowiings() {
        return imageFollowiings;
    }

    public void setImageFollowiings(int imageFollowiings) {
        this.imageFollowiings = imageFollowiings;
    }

    public String getFollowingsName() {
        return followingsName;
    }

    public void setFollowingsName(String followingsName) {
        this.followingsName = followingsName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
