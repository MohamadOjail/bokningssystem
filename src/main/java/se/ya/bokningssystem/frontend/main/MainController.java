package se.ya.bokningssystem.frontend.main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import lombok.Getter;
import se.ya.bokningssystem.frontend.switcher.Switcher;
import se.ya.bokningssystem.frontend.switcher.Views;

@Getter
public class MainController {
    @FXML private BorderPane app_pane;
    @FXML private ProgressBar loading_bar;
    @FXML private Label info;

    @FXML private void initialize(){

        Switcher.get().setApp_pane(app_pane);
        Switcher.get().loadScene(Views.LOGIN);
        Switcher.get().setLoading_bar(loading_bar);

        MainProgressListener progressListener = new MainProgressListener(this);
        loading_bar.progressProperty().addListener(progressListener);
    }
}