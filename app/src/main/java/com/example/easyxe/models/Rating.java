package com.example.easyxe.models;

public class Rating {
    private int imageView;
    private float ratingValue;
    private String fullName;
    private String report;

    //Constructor
    public Rating(int imageView, float ratingValue, String fullName, String report) {
        this.imageView = imageView;
        this.ratingValue = ratingValue;
        this.fullName = fullName;
        this.report = report;
    }

    // Get and set
    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public float getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
