package se.ya.bokningssystem.frontend.admin.user.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.frontend.admin.user.UserController;

public class AddSectionListener implements ChangeListener {
    private final UserController uc;

    public AddSectionListener(UserController uc) {
        this.uc = uc;
    }

    @Override
    public void changed(ObservableValue observableValue, Object o, Object t1) {
        boolean firstNameOk = !uc.getTf_add_f_name().getText().isEmpty();
        boolean lastNameOk = !uc.getTf_add_l_name().getText().isEmpty();
        boolean emailOk = !uc.getTf_add_email().getText().isEmpty();
        boolean statusOk = uc.getChoice_add_status().getSelectionModel().getSelectedItem() != null;

        boolean allFieldsOk = firstNameOk && lastNameOk && emailOk && statusOk;

        if (t1 != null){
            uc.getBtn_add().setDisable(!allFieldsOk);
        }
    }
}
