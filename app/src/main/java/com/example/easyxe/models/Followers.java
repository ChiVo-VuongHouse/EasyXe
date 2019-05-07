package com.example.easyxe.models;

public class Followers {
    private int imageFollowers;
    private String followersName;

    public Followers(int imageFollowers, String followersName) {
        this.imageFollowers = imageFollowers;
        this.followersName = followersName;
    }

    public int getImageFollowers() {
        return imageFollowers;
    }

    public void setImageFollowers(int imageFollowers) {
        this.imageFollowers = imageFollowers;
    }

    public String getFollowersName() {
        return followersName;
    }

    public void setFollowersName(String followersName) {
        this.followersName = followersName;
    }
}
