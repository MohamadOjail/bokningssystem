package se.ya.bokningssystem.frontend.admin.user.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.frontend.admin.user.UserController;

public class EditSectionChangeListener implements ChangeListener {

    private final UserController uc;

    public EditSectionChangeListener(UserController uc) {
        this.uc = uc;
    }

    @Override
    public void changed(ObservableValue observableValue, Object o, Object t1) {
        if (t1 != null){
            uc.getBtn_update().setDisable(false);
            return;
        }
        uc.getBtn_update().setDisable(true);
    }
}
