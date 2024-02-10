/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recipetherapy;

import java.text.DecimalFormat;


/**
 *
 * @author amjad
 */
import java.sql.Blob;
public class Recipe{
    int recipe_id;
    String chef_name;
    String name;
    String instructions;
    String category;
    String country;
    int cook_time;
    double calories;
    double protein;
    double carbs;
    double fibres;
    double fats;
    Blob image;
    Float rating;

    public Recipe(int recipe_id, String chef_name, String name, String category, String country, int cook_time , Float rating) {
        this.recipe_id = recipe_id;
        this.chef_name = chef_name;
        this.name = name;
        this.category = category;
        this.cook_time = cook_time;
        this.country = country;
        this.rating = rating;

    }

    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getChef_name() {
        return chef_name;
    }

    public void setChef_name(String chef_name) {
        this.chef_name = chef_name;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCook_time() {
        return cook_time;
    }

    public void setCook_time(int cook_time) {
        this.cook_time = cook_time;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFibres() {
        return fibres;
    }

    public void setFibres(double fibres) {
        this.fibres = fibres;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Recipe(int recipe_id, String name, String instructions, String category, int cook_time, double calories, double protein, double carbs, double fibres, double fats, Blob image) {
        this.recipe_id = recipe_id;
        this.name = name;
        this.instructions = instructions;
        this.category = category;
        this.cook_time = cook_time;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fibres = fibres;
        this.fats = fats;
        this.image = image;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return "<html> Recipe Name: " + name + "<br/>Chef: " + chef_name +"<br/>Category: " + category + "<br/>Cooking Time: " + cook_time + " Minutes<br/> Rating: "
                + (rating == 0 ? "Not rated" : decimalFormat.format(rating)) + "<br>____________________________________________";
    }
    
    
    
}