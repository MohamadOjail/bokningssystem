package se.ya.bokningssystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import se.ya.bokningssystem.backend.dao.BookingDAO;

import java.io.IOException;

public class MainWithFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainWithFX.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        new BookingDAO().recheckStatus();
    }

    public static void main(String[] args) {
        launch();
    }
}