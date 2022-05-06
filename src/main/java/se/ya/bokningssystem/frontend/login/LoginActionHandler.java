package se.ya.bokningssystem.frontend.login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressIndicator;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.frontend.switcher.ObjectHolder;
import se.ya.bokningssystem.frontend.switcher.Switcher;
import se.ya.bokningssystem.frontend.switcher.Views;
import se.ya.bokningssystem.frontend.utils.Threader;

public class LoginActionHandler implements EventHandler<ActionEvent> {

    private final LoginController lc;
    private UserEO byInput;

    public LoginActionHandler(LoginController lc) {
        this.lc = lc;
    }

    @Override
    public void handle(ActionEvent e) {
        boolean isUser = lc.getTf_admin_code().isDisable();
        UserDAO userDAO = new UserDAO();

        if (isUser) {

            Threader.execute(
                    () -> {
                        byInput = userDAO.getByInput(lc.getTf_user_name().getText());
                        ObjectHolder.get().setCurrentUser(byInput);
                    },
                    () -> {
                        if (byInput == null){
                            new Alert(Alert.AlertType.ERROR, "user not found").showAndWait();
                        }else {
                            Switcher.get().loadScene(Views.USER);
                        }
                    }
            );
        }

        if (!isUser){
            Switcher.get().loadScene(Views.ADMIN);
        }
    }
}
