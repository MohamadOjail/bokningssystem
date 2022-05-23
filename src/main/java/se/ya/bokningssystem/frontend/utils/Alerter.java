package se.ya.bokningssystem.frontend.utils;

import javafx.scene.control.Alert;

public class Alerter {
    private static final Alerter instance = new Alerter();
    public static Alerter get(){return instance;}
    private Alerter() {}

    public void showMessage(Alert.AlertType type, String message){
        Alert alert = new Alert(type);
        alert.setHeaderText(message);
        alert.setContentText(null);
        alert.show();
    }
}
