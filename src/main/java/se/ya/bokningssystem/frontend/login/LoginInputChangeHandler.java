package se.ya.bokningssystem.frontend.login;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class LoginInputChangeHandler implements EventHandler<KeyEvent> {

    private final LoginController lc;

    public LoginInputChangeHandler(LoginController lc) {
        this.lc = lc;
    }

    @Override
    public void handle(KeyEvent ke) {
        lc.getTf_user_name().setDisable(ke.getSource() == lc.getTf_admin_code() && !lc.getTf_admin_code().getText().isBlank());
        lc.getTf_admin_code().setDisable(ke.getSource() == lc.getTf_user_name() && !lc.getTf_user_name().getText().isBlank());
    }
}
