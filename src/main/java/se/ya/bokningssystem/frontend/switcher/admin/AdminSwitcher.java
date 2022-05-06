package se.ya.bokningssystem.frontend.switcher.admin;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ProgressBar;
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
    public void loadScene(Views scene) {

        switch (scene) {
            case USER -> path = "../../../admin/User.fxml";
            case BOOKING -> path = "../../../admin/Booking.fxml";
            case RESOURCE -> path = "../../../admin/Resource.fxml";
        }
        switchTo();
    }

    private void switchTo() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            admin_pane.setCenter(loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
