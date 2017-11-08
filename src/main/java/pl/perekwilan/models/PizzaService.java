package pl.perekwilan.models;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.perekwilan.models.utils.Config;
import pl.perekwilan.models.utils.HttpUtils;

public class PizzaService {
    public void makeCall (String city) {
        parseJsonData(HttpUtils.makeHttpRequest(Config.APP_URL + city + "&appid=" + Config.APP_ID));//makeHttpRequest - zwraca tekst html
    }

    private void parseJsonData(String text){
        JSONObject root = new JSONObject(text);
        JSONArray results = root.getJSONArray("results");




    }
}
