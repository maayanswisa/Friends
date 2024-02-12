package com.example.friends;

public class TVCharacter {
    private String name;
    private String description;
    private int imageResId;

    public TVCharacter(String name, String description, int imageResId) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }
}
