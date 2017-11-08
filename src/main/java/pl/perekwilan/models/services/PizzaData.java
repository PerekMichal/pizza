package pl.perekwilan.models.services;

public class PizzaData {

    private String city;                    //moglbys jutro wyciagnac dla miasta rating pizzy z JSONa
    private String pizza;
    private float rating;

    public PizzaData(){

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
