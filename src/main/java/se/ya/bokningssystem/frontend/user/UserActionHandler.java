package se.ya.bokningssystem.frontend.user;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import se.ya.bokningssystem.frontend.switcher.Switcher;
import se.ya.bokningssystem.frontend.switcher.Views;

public class UserActionHandler implements EventHandler<MouseEvent> {

    private final UserController uc;

    public UserActionHandler(UserController uc) {
        this.uc = uc;
    }

    @Override
    public void handle(MouseEvent e) {
        if (e.getSource() == uc.getLbl_log_out()){
            uc.setCurrentUser(null);
            Switcher switcher = new Switcher();
            switcher.loadScene(Views.MAIN, uc.getLbl_log_out());
        }
    }
}
