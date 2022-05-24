package se.ya.bokningssystem.frontend.user.setup.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.frontend.user.setup.SetupController;

import java.time.LocalDate;

public class DateChangeListener implements ChangeListener<LocalDate> {

    private final SetupController sc;

    public DateChangeListener(SetupController sc) {
        this.sc = sc;
    }

    @Override
    public void changed(ObservableValue<? extends LocalDate> observableValue, LocalDate localDate, LocalDate t1) {
        sc.getBtn_ok().setDisable(sc.getDp_booking_date().getValue() == null || sc.getDp_return_date().getValue() == null);
    }
}
