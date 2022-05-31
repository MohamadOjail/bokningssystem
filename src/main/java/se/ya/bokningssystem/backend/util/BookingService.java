package se.ya.bokningssystem.backend.util;

import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.BookingNamedQueries;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private final ResourceDAO resourceDAO = new ResourceDAO();
    private final BookingDAO bookingDAO = new BookingDAO();
    private final ResourceService resourceService = new ResourceService();

    public void bookResource(UserEO user, LocalDate bookingDate, LocalDate returnDate, ResourceEO resource){
        BookingEO bookingEO = new BookingEO();
        bookingEO.setBookingDate(bookingDate);
        bookingEO.setResource(resource);
        bookingEO.setStatus(BookingStatus.ACTIVE);
        bookingEO.setUser(user);
        bookingEO.setReturnDate(returnDate);
        bookingEO.setReminderDate(returnDate.minusDays(1));

        bookingDAO.add(bookingEO);
    }

    public void closeBooking(BookingEO booking){
        booking.setStatus(BookingStatus.FINISHED);
        booking.setActualReturnDate(LocalDate.now());
        bookingDAO.update(booking);
        resourceService.refreshResourceStatus(booking.getResource());
    }

    public void deleteBooking(BookingEO booking){
        ResourceEO resource = booking.getResource();
        bookingDAO.delete(booking.getId());
        resourceService.refreshResourceStatus(resource);
    }

    public void markBookingAsOverdue(BookingEO booking){
        booking.setReturnDate(LocalDate.now().minusDays(1));
        booking.setStatus(BookingStatus.OVERDUE);
        bookingDAO.update(booking);
        resourceService.refreshResourceStatus(booking.getResource());
    }

    public List<BookingEO> getBookingsWithResource(ResourceEO resource){
        return bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_BY_RESOURCE.queryName, resource);
    }

    public List<BookingEO> getOpenBookingsWithResource(ResourceEO resource){
        List<BookingEO> output = new ArrayList<>();
        for (BookingEO booking: bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_BY_RESOURCE.queryName, resource)){
            if (booking.getStatus() != BookingStatus.FINISHED) output.add(booking);
        }
        return output;
    }

    public void refreshAllBookings(){
        bookingDAO.recheckStatus();
    }
}
