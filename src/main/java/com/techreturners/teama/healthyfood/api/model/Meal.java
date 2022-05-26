package com.techreturners.teama.healthyfood.api.model;

import com.techreturners.teama.healthyfood.api.util.Json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Meal {
    private String mealId;
    private String name;
    private String photo;
    private String servings;
    private String preptime;
    private String ingredients;
    private String diet;

    public Meal() {

    }


    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getPreptime() {
        return preptime;
    }

    public void setPreptime(String prepTime) {
        this.preptime = prepTime;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }


    public List<Diet> getDietList() throws IOException, InterruptedException {
        if (diet == null)
            return new ArrayList<Diet>();
        ArrayList<Diet> list = new ArrayList<Diet>();

        String d[] = diet.split(",");

        for (String dt : d) {
            list.add(Json.geDietList().stream().filter(i -> i.getName().equals(dt))
                    .findAny().get());
        }
        return list;
    }
}
