package se.ya.bokningssystem.frontend.login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Getter;
import se.ya.bokningssystem.frontend.switcher.Switcher;

@Getter
public class LoginController {

    @FXML private Button btn_login;
    @FXML private TextField tf_admin_code, tf_user_name;

    @FXML private void initialize(){

        LoginActionHandler actionHandler = new LoginActionHandler(this);
        btn_login.setOnAction(actionHandler);

        LoginInputChangeHandler inputChangeHandler = new LoginInputChangeHandler(this);
        tf_admin_code.setOnKeyTyped(inputChangeHandler);
        tf_user_name.setOnKeyTyped(inputChangeHandler);

    }
}
