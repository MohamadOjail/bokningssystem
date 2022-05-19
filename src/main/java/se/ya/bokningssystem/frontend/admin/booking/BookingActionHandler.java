package se.ya.bokningssystem.frontend.admin.booking;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BookingActionHandler implements EventHandler<ActionEvent> {

    private final BookingController bc;

    public BookingActionHandler(BookingController bc) {
        this.bc = bc;
    }

    @Override
    public void handle(ActionEvent e) {

    }
}
