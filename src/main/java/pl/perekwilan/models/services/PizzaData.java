package pl.perekwilan.models.services;

import java.util.ArrayList;

public class PizzaData {

    private String city;                    //moglbys jutro wyciagnac dla miasta rating pizzy z JSONa
    private String name;
    private float rating;
    private float max;


    public PizzaData(){

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }
}
