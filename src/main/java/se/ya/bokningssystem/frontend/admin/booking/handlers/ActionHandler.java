package se.ya.bokningssystem.frontend.admin.booking.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import se.ya.bokningssystem.frontend.admin.booking.BookingController;

public class ActionHandler implements EventHandler<ActionEvent> {
    private final BookingController bc;

    public ActionHandler(BookingController bc) {
        this.bc = bc;
    }

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == bc.getBtn_delete()){
            // TODO
        }
        if (e.getSource() == bc.getBtn_finish()){
            // TODO
        }
        if (e.getSource() == bc.getBtn_overdue()){
            // TODO
        }
    }
}
