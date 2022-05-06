package se.ya.bokningssystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import se.ya.bokningssystem.frontend.main.MainController;

import java.io.IOException;

public class MainWithFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainWithFX.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MainController controller = fxmlLoader.getController();
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        try {
            Thread.sleep(100);
            controller.getTf_user_name().requestFocus();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}