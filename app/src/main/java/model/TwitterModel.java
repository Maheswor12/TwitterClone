package model;

public class TwitterModel {
    private int profile_image;
    private String name, username, tweet;


    public TwitterModel(int profile_image, String name, String username, String tweet) {
        this.profile_image = profile_image;
        this.name = name;
        this.username = username;
        this.tweet = tweet;
    }


    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
