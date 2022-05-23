package se.ya.bokningssystem.frontend.admin.user;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.backend.entity.UserEO;

public class UserChangeListener implements ChangeListener<UserEO>{
    private final UserController uc;

    public UserChangeListener(UserController uc) {
        this.uc = uc;
    }

    @Override
    public void changed(ObservableValue<? extends UserEO> observable, UserEO userEO, UserEO t1) {
        if (t1 != null){

        }
    }
}
