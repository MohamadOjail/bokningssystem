package se.ya.bokningssystem.frontend.admin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import se.ya.bokningssystem.frontend.switcher.Switcher;
import se.ya.bokningssystem.frontend.switcher.Views;

public class AdminActionHandler implements EventHandler<ActionEvent> {

    private final AdminController ac;

    public AdminActionHandler(AdminController ac) {
        this.ac = ac;
    }

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == ac.getBtn_logoff()){
            Switcher.get().loadScene(Views.LOGIN);
        }
    }
}
