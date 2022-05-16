package se.ya.bokningssystem.frontend.switcher.admin;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Setter
@Getter
public class AdminSwitcher {

    private static AdminSwitcher instance = new AdminSwitcher();
    public static AdminSwitcher get() {return instance;}
    private AdminSwitcher() {}

    private BorderPane admin_pane;
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    protected String path;
    public void loadScene(AdminViews scene) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(scene.path));
            admin_pane.setCenter(loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
