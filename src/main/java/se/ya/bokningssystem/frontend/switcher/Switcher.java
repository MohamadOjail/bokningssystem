package se.ya.bokningssystem.frontend.switcher;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import se.ya.bokningssystem.frontend.main.MainController;

import java.io.IOException;

public class Switcher {

    public void loadScene(Views scene, Node node){

        MainController mainController = null;
        Parent root = null;

        try {
            switch (scene){
                case MAIN -> {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../../Main.fxml"));
                    root = loader.load();
                    mainController = loader.getController();
                }
                case USER -> {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../../User.fxml"));
                    root = loader.load();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stage stage = (Stage) node.getScene().getWindow();
        Scene sceneX = new Scene(root);
        stage.setScene(sceneX);
        stage.setMaximized(false);
        stage.setMaximized(true);
        if (mainController != null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            mainController.getTf_user_name().requestFocus();
        }
    }
}
