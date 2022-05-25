package se.ya.bokningssystem.frontend.user.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;
import se.ya.bokningssystem.frontend.user.UserController;

public class BookingListChangeListener implements ChangeListener<BookingEO> {

    private final UserController uc;

    public BookingListChangeListener(UserController uc) {
        this.uc = uc;
    }

    @Override
    public void changed(ObservableValue<? extends BookingEO> observableValue, BookingEO bookingEO, BookingEO t1) {
        uc.getBtn_cancel_booking().setDisable(
                t1 == null ||
                !uc.getTv_bookings().getSelectionModel().getSelectedItem().getStatus().equals(BookingStatus.ACTIVE)
        );

        uc.getBtn_return_resource().setDisable(
                t1 == null ||
                uc.getTv_bookings().getSelectionModel().getSelectedItem().getStatus().equals(BookingStatus.FINISHED)
        );
    }
}
