package pl.perekwilan.models.services;

public class PizzaData {

    private String city;                    //moglbys jutro wyciagnac dla miasta rating pizzy z JSONa
    private String name;
    private float maxRating;


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

    public float getMaxRating() {
        return maxRating;
    }

    public void setMaxRating(float maxRating) {
        this.maxRating = maxRating;
    }

}
