package pl.perekwilan.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import pl.perekwilan.models.services.PizzaData;
import pl.perekwilan.models.services.PizzaObserver;
import pl.perekwilan.models.services.PizzaService;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;


public class MainController implements Initializable, PizzaObserver {

    @FXML
    Button buttonMakePizz;

    @FXML
    TextField giveCity;

    @FXML
    Label theBestPizza;


    private PizzaService pizzaService = PizzaService.getService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pizzaService.registerObserver(this);
        buttonMakePizz.setOnMouseClicked(s ->  showPizza());
    }


    private void showPizza() {
        pizzaService.makeCall(giveCity.getText());
    }


    @Override
    public void onPizzaUpdate(PizzaData data) {
    Platform.runLater(() -> theBestPizza.setText("Name: " + data.getName() + ". Rating: " + data.getRating()));
    }
}
