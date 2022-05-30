package se.ya.bokningssystem.frontend.admin.report.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.frontend.admin.report.ReportController;


public class UserChangeListener implements ChangeListener<UserEO> {
    private final ReportController rc;


    public UserChangeListener(ReportController rc) {
        this.rc = rc;

    }

    @Override
    public void changed(ObservableValue<? extends UserEO> observable, UserEO oldValue, UserEO newValue) {
        System.out.println(newValue);
        if (newValue != null){
            rc.getCb_resource().getSelectionModel().select(null);
            rc.getFinder().populateByUser(newValue);
            return;
        }
        rc.getFinder().populateNoFilter();

    }
}
