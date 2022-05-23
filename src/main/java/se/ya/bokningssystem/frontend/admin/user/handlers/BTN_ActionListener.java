package se.ya.bokningssystem.frontend.admin.user.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.frontend.admin.user.UserController;

public class BTN_ActionListener implements EventHandler<ActionEvent> {
    private final UserController uc;
    private final UserDAO userDAO = new UserDAO();
    private UserEO selectedUser;

    public BTN_ActionListener(UserController uc) {
        this.uc = uc;
    }

    @Override
    public void handle(ActionEvent e) {

        selectedUser = uc.getTv().getSelectionModel().getSelectedItem();

        if (e.getSource() == uc.getBtn_delete()){
            userDAO.delete(selectedUser.getId());
            uc.getUsers().remove(selectedUser);
            uc.getTv().getSelectionModel().select(null);
        }
        if (e.getSource() == uc.getBtn_edit()){
            uc.getBtn_update().setDisable(false);
            uc.getBtn_edit().setDisable(!uc.getBtn_edit().isDisable());
        }
        if (e.getSource() == uc.getBtn_update()){
            setUserFields(selectedUser, false);
            userDAO.update(selectedUser);
            int index = uc.getUsers().indexOf(selectedUser);
            setUserFields(uc.getUsers().get(index), false);
            uc.getTv().refresh();
            uc.getBtn_update().setDisable(true);
            uc.getTv().getSelectionModel().select(null);
            showInfo(Alert.AlertType.INFORMATION, "Användaren uppdaterats");
        }
        if (e.getSource() == uc.getBtn_add()){
           UserEO userEO = new UserEO();
            setUserFields(userEO, true);
            userDAO.add(userEO);
            showInfo(Alert.AlertType.INFORMATION, "Ny Användare sparats");
        }
    }
    private void setUserFields(UserEO userEO, boolean newUser){
        if (!newUser) {
            userEO.setFirstName(uc.getTf_edit_f_name().getText());
            userEO.setLastName(uc.getTf_edit_l_name().getText());
            userEO.setEmail(uc.getTf_edit_email().getText());
            userEO.setCanBorrow(uc.getChoice_edit_status().getSelectionModel().getSelectedItem());
            return;
        }
        userEO.setFirstName(uc.getTf_add_f_name().getText());
        userEO.setLastName(uc.getTf_add_l_name().getText());
        userEO.setEmail(uc.getTf_add_email().getText());
        userEO.setCanBorrow(uc.getChoice_add_status().getSelectionModel().getSelectedItem());
        clearAddSection();
    }

    private void clearAddSection(){
        uc.getTf_add_f_name().clear();
        uc.getTf_add_l_name().clear();
        uc.getTf_add_email().clear();
        uc.getChoice_add_status().getSelectionModel().select(null);
    }

    private void showInfo(Alert.AlertType type, String message){
        Alert infoMessage = new Alert(type);
        infoMessage.setHeaderText(message);
        infoMessage.setContentText(null);
        infoMessage.show();
    }
}
