package se.ya.bokningssystem.frontend.main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.frontend.switcher.Switcher;
import se.ya.bokningssystem.frontend.switcher.Views;

public class MainActionHandler implements EventHandler<ActionEvent> {

    private final MainController mc;

    public MainActionHandler(MainController mc) {
        this.mc = mc;
    }

    @Override
    public void handle(ActionEvent e) {
        boolean isAdmin = mc.getTf_admin_code().isDisable();
        UserDAO userDAO = new UserDAO();
//        UserEO byInput = userDAO.getByInput(mc.getTf_user_name().getText());
//        new Alert(Alert.AlertType.INFORMATION, byInput.getFirstName()).show();
        if (e.getSource() == mc.getBtn_login() && isAdmin){
            Switcher switcher = new Switcher();
            switcher.loadScene(Views.USER, mc.getBtn_login());
        }
    }
}
