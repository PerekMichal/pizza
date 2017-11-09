package pl.perekwilan.models;

public class PizzaModel {

    private String city;
    private float rating;

    public PizzaModel(String city, float rating) {
        this.city = city;
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "PizzaModel{" +
                "city='" + city + '\'' +
                ", rating=" + rating +
                '}';
    }
}
