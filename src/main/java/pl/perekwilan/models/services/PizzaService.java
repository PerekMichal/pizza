package pl.perekwilan.models.services;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.perekwilan.models.utils.Config;
import pl.perekwilan.models.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PizzaService {

    private static PizzaService ourInstance = new PizzaService();

    public static PizzaService getService() {
        return ourInstance;
    }

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

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
        executorService.execute(() -> {
            parseJsonData(HttpUtils.makeHttpRequest(Config.APP_URL1 + city + "&key=" + Config.APP_ID));//makeHttpRequest - zwraca tekst html
        });
    }

    private void parseJsonData(String text){
        JSONObject root = new JSONObject(text);
        JSONArray results = root.getJSONArray("results");
        List<PizzaData> dataList = new ArrayList<>();
        PizzaData data = null;
        float maxRating = 0;
        for (int i = 0; i < results.length(); i++) {
            JSONObject main = results.getJSONObject(i);

            float rating = main.getFloat("rating");
            String name = main.getString("name");

            data = new PizzaData();
            data.setRating(rating);
            data.setName(name);
            dataList.add(data);
            System.out.println(name + rating);

        }
        notifyObservers(data);

    }
}
