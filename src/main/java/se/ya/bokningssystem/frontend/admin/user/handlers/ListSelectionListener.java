package se.ya.bokningssystem.frontend.admin.user.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.frontend.admin.user.UserController;

public class ListSelectionListener implements ChangeListener<UserEO> {

    private final UserController uc;
    public ListSelectionListener(UserController uc) {
        this.uc = uc;
    }

    @Override
    public void changed(ObservableValue<? extends UserEO> observableValue, UserEO userEO, UserEO t1) {
        if (t1 != null){

            selectSectionButtonsEnabler(false);
            setEditSectionValues(t1);
            return;
        }
        selectSectionButtonsEnabler(true);
        setEditSectionValues(null);
    }
    private void selectSectionButtonsEnabler(boolean disable){
        uc.getBtn_delete().setDisable(disable);
        uc.getBtn_edit().setDisable(disable);
    }
    private void setEditSectionValues(UserEO user){
        if (user == null){
            uc.getTf_edit_f_name().clear();
            uc.getTf_edit_l_name().clear();
            uc.getTf_edit_email().clear();
            uc.getChoice_edit_status().getSelectionModel().select(null);
            return;
        }
        uc.getBtn_update().setDisable(true);
        uc.getTf_edit_f_name().setText(user.getFirstName());
        uc.getTf_edit_l_name().setText(user.getLastName());
        uc.getTf_edit_email().setText(user.getEmail());
        uc.getChoice_edit_status().getSelectionModel().select(user.isCanBorrow());
    }
}
