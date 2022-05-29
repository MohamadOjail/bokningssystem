package se.ya.bokningssystem.frontend.admin.booking.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;
import se.ya.bokningssystem.backend.entity.enums.ResourceStatus;
import se.ya.bokningssystem.frontend.admin.booking.BookingController;

import java.time.LocalDate;

public class ActionHandler implements EventHandler<ActionEvent> {
    private final BookingController bc;
    private final ResourceDAO resourceDAO = new ResourceDAO();
    private final BookingDAO bookingDAO = new BookingDAO();
    public ActionHandler(BookingController bc) {this.bc = bc;}

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == bc.getBtn_delete()){
            ResourceEO resourceEO = bc.getTv().getSelectionModel().getSelectedItem().getResource();
            resourceEO.setStatus(ResourceStatus.AVAILABLE);
            bookingDAO.delete(bc.getTv().getSelectionModel().getSelectedItem().getId());
            refreshBookingList();
        }
        if (e.getSource() == bc.getBtn_finish()){
            ResourceEO resourceEO = bc.getTv().getSelectionModel().getSelectedItem().getResource();
            resourceEO.setStatus(ResourceStatus.AVAILABLE);
            resourceDAO.update(resourceEO);
            BookingEO selectedBooking = bc.getTv().getSelectionModel().getSelectedItem();
            selectedBooking.setStatus(BookingStatus.FINISHED);
            selectedBooking.setActualReturnDate(LocalDate.now());
            bookingDAO.update(selectedBooking);
            refreshBookingList();
            bc.getTv().refresh();
        }
        if (e.getSource() == bc.getBtn_overdue()){
            ResourceEO resourceEO = bc.getTv().getSelectionModel().getSelectedItem().getResource();
            resourceEO.setStatus(ResourceStatus.AVAILABLE);
            BookingEO selectedBooking = bc.getTv().getSelectionModel().getSelectedItem();
            selectedBooking.setStatus(BookingStatus.OVERDUE);
            bookingDAO.update(selectedBooking);
            refreshBookingList();
        }
    }

    private void refreshBookingList(){
        bc.getBookings().clear();
        bc.getBookings().addAll(bookingDAO.findAll());
    }
}
