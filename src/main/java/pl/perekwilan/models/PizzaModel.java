package pl.perekwilan.models;

public class PizzaModel {

    private String city;

    public PizzaModel(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "PizzaModel{" +
                "city='" + city + '\'' +
                '}';
    }
}
