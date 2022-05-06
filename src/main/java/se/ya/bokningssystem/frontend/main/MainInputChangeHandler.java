package se.ya.bokningssystem.frontend.main;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class MainInputChangeHandler implements EventHandler<KeyEvent> {

    private MainController mc;

    public MainInputChangeHandler(MainController mc) {
        this.mc = mc;
    }


    @Override
    public void handle(KeyEvent ke) {
        mc.getTf_user_name().setDisable(ke.getSource() == mc.getTf_admin_code() && !mc.getTf_admin_code().getText().isBlank());
        mc.getTf_admin_code().setDisable(ke.getSource() == mc.getTf_user_name() && !mc.getTf_user_name().getText().isBlank());
    }
}
