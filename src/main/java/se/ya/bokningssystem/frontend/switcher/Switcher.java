package se.ya.bokningssystem.frontend.switcher;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import se.ya.bokningssystem.frontend.login.LoginController;
import se.ya.bokningssystem.frontend.main.MainController;

import java.io.IOException;

@Setter
@Getter
public class Switcher {

    private static Switcher instance = new Switcher();
    public static Switcher get() {return instance;}
    private Switcher() {}

    private BorderPane app_pane;
    private ProgressBar loading_bar;
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    protected String path;
    public void loadScene(Views scene) {

        switch (scene) {
            case LOGIN -> path = "../../Login.fxml";
            case USER -> path = "../../User.fxml";
            case ADMIN -> path = "../../Admin.fxml";
        }
        switchTo();
    }

    private void switchTo() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            app_pane.setCenter(loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
