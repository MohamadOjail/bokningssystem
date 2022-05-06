package se.ya.bokningssystem.frontend.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.Getter;

@Getter
public class AdminController {

    @FXML private Button btn_logoff;

    @FXML private void initialize(){
        AdminActionHandler actionHandler = new AdminActionHandler(this);
        btn_logoff.setOnAction(actionHandler);
    }
}
