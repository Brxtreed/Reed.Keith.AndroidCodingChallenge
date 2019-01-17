package com.androidcodingchallenge.keith.reed.reedkeithandroidcodingchallenge.DataModel;

public class Book {
    @com.google.gson.annotations.SerializedName("title")
    private String title;

    @com.google.gson.annotations.SerializedName("imageURL")
    private String imageURL;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
