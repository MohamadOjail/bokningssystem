package se.ya.bokningssystem.frontend.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import lombok.Getter;
import se.ya.bokningssystem.frontend.switcher.admin.AdminSwitcher;
import se.ya.bokningssystem.frontend.switcher.admin.AdminViews;
@Getter
public class AdminController {
    @FXML private VBox admin_container;
    @FXML private BorderPane admin_pane;
    @FXML private ToggleButton btn_booking, btn_resource, btn_user, btn_inventory, btn_report;
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
        btn_inventory.setOnAction(actionHandler);
        btn_report.setOnAction(actionHandler);
    }
}