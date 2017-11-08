package pl.perekwilan.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.perekwilan.models.services.PizzaService;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    @FXML
    Button buttonMakePizz;

    @FXML
    TextField giveCity;

    @FXML
    Label theBestPizza;

    private PizzaService pizzaService = PizzaService.getService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    private void showPizza() {
        pizzaService.makeCall(giveCity.getText());
    }




}
