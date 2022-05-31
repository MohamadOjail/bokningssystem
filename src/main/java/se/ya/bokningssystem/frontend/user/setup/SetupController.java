package se.ya.bokningssystem.frontend.user.setup;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import lombok.Getter;
import lombok.Setter;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.util.BookingService;
import se.ya.bokningssystem.frontend.switcher.ObjectHolder;
import se.ya.bokningssystem.frontend.user.UserController;
import se.ya.bokningssystem.frontend.user.setup.handlers.ActionHandler;
import se.ya.bokningssystem.frontend.user.setup.handlers.DateChangeListener;
import se.ya.bokningssystem.frontend.utils.Alerter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class SetupController {
    @FXML private Button btn_cancel, btn_ok;
    @FXML private DatePicker dp_booking_date, dp_return_date;
    @Setter
    private UserController uc;
    private final BookingService bookingService = new BookingService();

    @FXML private void initialize(){

        ResourceEO resource = ObjectHolder.get().getUserSelectedResource();
        List<BookingEO> bookings = bookingService.getOpenBookingsWithResource(resource);

        dp_booking_date.setDayCellFactory(datePicker -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                setId("allowed");
                for (BookingEO x : bookings){
                    boolean beforeToday = item.isBefore(LocalDate.now());
                    boolean notBeforeMe = item.isBefore(x.getReturnDate()) && !item.isBefore(x.getBookingDate());
                    boolean starter = item.isEqual(x.getBookingDate());

                    if (notBeforeMe || starter || beforeToday){
                        setDisable(true);
                        setId("not-allowed");
                    }
                }
            }
        });


        dp_return_date.setDayCellFactory(datePicker -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                setId("allowed");

                boolean atBookingDate = item.isBefore(dp_booking_date.getValue()) ||
                        item.isEqual(dp_booking_date.getValue()) ||
                        item.isEqual(dp_booking_date.getValue().plusDays(1)) ||
                        item.isEqual(dp_booking_date.getValue().plusDays(2));

                if (atBookingDate || item.isAfter(dp_booking_date.getValue().plusDays(360))) {
                    setDisable(true);
                    setId("not-allowed");
                }
                Object o= getFirstDate(bookings, dp_booking_date.getValue());
                if (o != null) {
                    if (item.isAfter((LocalDate)o)) {
                        setDisable(true);
                        setId("not-allowed");
                    }
                }
            }
        });
        DateChangeListener dateChangeListener = new DateChangeListener(this);
        dp_booking_date.valueProperty().addListener(dateChangeListener);
        dp_return_date.valueProperty().addListener(dateChangeListener);

        // button Action event
        ActionHandler actionHandler = new ActionHandler(this);
        btn_cancel.setOnAction(actionHandler);
        btn_ok.setOnAction(actionHandler);
    }
    private LocalDate getFirstDate(List<BookingEO> bookings, LocalDate date){
        List<LocalDate> dates = new ArrayList<>();
        for (BookingEO booking : bookings){
            if (booking.getBookingDate().isAfter(date)) dates.add(booking.getBookingDate());
        }
        Collections.sort(dates);
        if (!dates.isEmpty()) return dates.get(0).minusDays(1);
        else return null;
    }
}
