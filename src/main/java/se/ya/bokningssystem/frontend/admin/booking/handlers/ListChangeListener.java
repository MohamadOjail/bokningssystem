package se.ya.bokningssystem.frontend.admin.booking.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.frontend.admin.booking.BookingController;

public class ListChangeListener implements ChangeListener<BookingEO> {
    private final BookingController bc;

    public ListChangeListener(BookingController bc) {
        this.bc = bc;
    }

    @Override
    public void changed(ObservableValue<? extends BookingEO> observableValue, BookingEO bookingEO, BookingEO t1) {

    }
}
