package se.ya.bokningssystem.frontend.admin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import se.ya.bokningssystem.frontend.switcher.admin.AdminSwitcher;
import se.ya.bokningssystem.frontend.switcher.admin.Views;

public class AdminActionHandler implements EventHandler<ActionEvent> {

    private final AdminController ac;

    public AdminActionHandler(AdminController ac) {
        this.ac = ac;
    }

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == ac.getBtn_user()){
            AdminSwitcher.get().loadScene(Views.USER);
        }
        if (e.getSource() == ac.getBtn_resource()){
            AdminSwitcher.get().loadScene(Views.RESOURCE);
        }
        if (e.getSource() == ac.getBtn_booking()){
            AdminSwitcher.get().loadScene(Views.BOOKING);
        }

    }
}
