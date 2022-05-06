package se.ya.bokningssystem.frontend.admin;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import lombok.Getter;
import se.ya.bokningssystem.frontend.switcher.admin.AdminSwitcher;
import se.ya.bokningssystem.frontend.switcher.admin.Views;
@Getter
public class AdminController {

    @FXML private BorderPane admin_pane;
    @FXML private ToggleButton btn_booking, btn_resource, btn_user;
    @FXML private ToggleGroup t;

    @FXML
    private void initialize() {
        AdminSwitcher.get().setAdmin_pane(admin_pane);
        AdminSwitcher.get().loadScene(Views.USER);

        AdminActionHandler actionHandler = new AdminActionHandler(this);
        btn_booking.setOnAction(actionHandler);
        btn_user.setOnAction(actionHandler);
        btn_resource.setOnAction(actionHandler);
    }

}