package com.example.lab5.model;

public class FastFoodClass {

    public String fastFoodName;
    public String description;
    public String position;
    public String ingredients;
    public int imageId;

    public FastFoodClass(String fastFoodName, String description, int imageId,String position,String ingredients) {
        this.fastFoodName = fastFoodName;
        this.description = description;
        this.position = position;
        this.imageId = imageId;
        this.ingredients = ingredients;
    }
}
