package pl.perekwilan.models.services;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.perekwilan.models.utils.Config;
import pl.perekwilan.models.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

public class PizzaService {

    private static PizzaService ourInstance = new PizzaService();

    public static PizzaService getService() {
        return ourInstance;
    }

    private List<PizzaObserver> observers;

    private PizzaService(){
        observers = new ArrayList<>();
    }

    public void registerObserver(PizzaObserver observer){
        observers.add(observer);
    }

    private void notifyObservers(PizzaData data){
        for (PizzaObserver observer : observers){
            observer.onPizzaUpdate(data);
        }
    }


    public void makeCall (String city) {
        parseJsonData(HttpUtils.makeHttpRequest(Config.APP_URL1 + city + "&key" + Config.APP_ID));//makeHttpRequest - zwraca tekst html
    }

    private void parseJsonData(String text){
        JSONObject root = new JSONObject(text);
        JSONArray results = root.getJSONArray("results");

        PizzaData data;
        for (int i = 0; i < root.length(); i++) {
            JSONObject main = root.getJSONObject("main");

            float rating = root.getFloat("rating");

            data = new PizzaData();
            data.setRating(rating);
            System.out.println(rating);

        }


    }
}
