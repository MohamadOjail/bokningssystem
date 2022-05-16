package se.ya.bokningssystem.frontend.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import lombok.Getter;
import se.ya.bokningssystem.frontend.switcher.admin.AdminSwitcher;
import se.ya.bokningssystem.frontend.switcher.admin.AdminViews;
@Getter
public class AdminController {

    @FXML private BorderPane admin_pane;
    @FXML private ToggleButton btn_booking, btn_resource, btn_user;
    @FXML private ToggleGroup t;
    @FXML private Button btn_logg_out;

    @FXML
    private void initialize() {
        AdminSwitcher.get().setAdmin_pane(admin_pane);
        AdminSwitcher.get().loadScene(AdminViews.USER);

        AdminActionHandler actionHandler = new AdminActionHandler(this);
        btn_booking.setOnAction(actionHandler);
        btn_user.setOnAction(actionHandler);
        btn_resource.setOnAction(actionHandler);
        btn_logg_out.setOnAction(actionHandler);
    }

}