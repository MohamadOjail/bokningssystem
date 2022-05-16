package se.ya.bokningssystem;

import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;

import java.time.LocalDate;

public class MainConsole {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        ResourceDAO resourceDAO = new ResourceDAO();
        BookingDAO bookingDAO = new BookingDAO();

        UserEO userEO = userDAO.getById(1L);
        ResourceEO resourceEO = resourceDAO.getById(1L);

//        BookingEO bookingEO = new BookingEO();
//        bookingEO.setBookingDate(LocalDate.now());
//        bookingEO.setStatus(BookingStatus.ACTIVE);
//        bookingEO.setUser(userEO);
//        bookingEO.setResource(resourceEO);
//        bookingEO.setReturnDate(LocalDate.of(2022,05,22));
//        bookingEO.setReminderDate(LocalDate.of(2022,05,21));
//
//        bookingDAO.add(bookingEO);
//        userEO.addBooking(bookingEO);
//        userDAO.update(userEO);

//        bookingDAO.delete(5L);

        userDAO.delete(1L);

    }
}
