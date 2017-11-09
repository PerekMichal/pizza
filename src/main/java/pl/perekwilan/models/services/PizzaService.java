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
        parseJsonData(HttpUtils.makeHttpRequest(Config.APP_URL + city + "&appid=" + Config.APP_ID));//makeHttpRequest - zwraca tekst html
    }

    private void parseJsonData(String text){
        JSONObject root = new JSONObject(text);
        JSONArray results = root.getJSONArray("address_components");

//
//        int temp = results.getFloat("rating");
//        String name = root.

//
    }  PizzaData data = new PizzaData();
//
//        data.getRating(rating);
//        data.getCity(name);

}
