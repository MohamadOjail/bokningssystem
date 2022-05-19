package se.ya.bokningssystem.frontend.admin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import se.ya.bokningssystem.frontend.switcher.Switcher;
import se.ya.bokningssystem.frontend.switcher.Views;
import se.ya.bokningssystem.frontend.switcher.admin.AdminSwitcher;
import se.ya.bokningssystem.frontend.switcher.admin.AdminViews;

public class AdminActionHandler implements EventHandler<ActionEvent> {

    private final AdminController ac;

    public AdminActionHandler(AdminController ac) {
        this.ac = ac;
    }

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == ac.getBtn_user()){
            AdminSwitcher.get().loadScene(AdminViews.USER);
//            AdminSwitcher.get().getAdmin_pane().setMaxWidth(700);
        }
        if (e.getSource() == ac.getBtn_resource()){
            AdminSwitcher.get().loadScene(AdminViews.RESOURCE);
//            AdminSwitcher.get().getAdmin_pane().setMaxWidth(700);
        }
        if (e.getSource() == ac.getBtn_booking()){
            AdminSwitcher.get().loadScene(AdminViews.BOOKING);
//            AdminSwitcher.get().getAdmin_pane().setMaxWidth(1000);
        }

        if (e.getSource() == ac.getBtn_logg_out()){
            Switcher.get().loadScene(Views.LOGIN);
        }
    }
}
