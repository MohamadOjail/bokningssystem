package se.ya.bokningssystem.frontend.admin.user;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UserActionHandler implements EventHandler<ActionEvent> {

    private final UserController uc;

    public UserActionHandler(UserController uc) {
        this.uc = uc;
    }

    @Override
    public void handle(ActionEvent e) {

    }
}
