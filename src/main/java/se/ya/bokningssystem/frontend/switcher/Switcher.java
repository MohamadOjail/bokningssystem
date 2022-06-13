package se.ya.bokningssystem.frontend.switcher;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Setter
@Getter
public class Switcher {
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static Switcher instance = new Switcher();
    public static Switcher get() {return instance;}
    private Switcher() {}

    private BorderPane app_pane;
    private ProgressBar loading_bar;
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    protected String path;
    public void loadScene(Views scene) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(scene.path));
            app_pane.setCenter(loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
