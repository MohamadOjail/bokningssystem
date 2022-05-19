package se.ya.bokningssystem;

import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.ResourceStatus;

import java.time.LocalDate;
import java.util.Random;

public class DummyData {
    private static final Random rnd = new Random();
    public static void generateBookings(){
        BookingDAO bookingDAO = new BookingDAO();
        ResourceDAO resourceDAO = new ResourceDAO();
        UserDAO userDAO = new UserDAO();
        for (int i = 1; i <= 6; i++) {
            BookingEO bookingEO = new BookingEO();
            bookingEO.setBookingDate(LocalDate.of(2022, 05,i));
            bookingEO.setReturnDate(LocalDate.of(2022, 05,i+2));

            ResourceEO resourceEO = getResource();
            bookingEO.setResource(resourceEO);

            UserEO userEO = userDAO.getById(rnd.nextLong(userDAO.getUserCount()) + 1);
            bookingEO.setUser(userEO);

            bookingEO.setReminderDate(LocalDate.of(2022, 05,i+1));
            bookingDAO.add(bookingEO);

            resourceEO.setStatus(ResourceStatus.BORROWED);
            resourceEO.setAvailableDate(bookingEO.getReturnDate());
            resourceDAO.update(resourceEO);

            userEO.addBooking(bookingEO);
            userDAO.update(userEO);
        }
        for (int i = 1; i <= 4; i++) {
            BookingEO bookingEO = new BookingEO();
            bookingEO.setBookingDate(LocalDate.now());
            bookingEO.setReturnDate(LocalDate.now().plusMonths(2L));

            ResourceEO resourceEO = getResource();
            bookingEO.setResource(resourceEO);

            UserEO userEO = userDAO.getById(rnd.nextLong(userDAO.getUserCount()) + 1);
            bookingEO.setUser(userEO);

            bookingEO.setReminderDate(LocalDate.now().plusMonths(2L).minusDays(2L));
            bookingDAO.add(bookingEO);

            resourceEO.setStatus(ResourceStatus.BORROWED);
            resourceDAO.update(resourceEO);

            userEO.addBooking(bookingEO);
            userDAO.update(userEO);
        }
    }

    private static ResourceEO getResource(){
        ResourceDAO resourceDAO = new ResourceDAO();
        Long seed = resourceDAO.getResourceCount();
        Long index = rnd.nextLong(seed) + 1;
        ResourceEO resourceEO = resourceDAO.getById(index);
        return resourceEO.getStatus() == ResourceStatus.AVAILABLE ? resourceEO : getResource();
    }

    public static void generateUsers(){
        UserDAO userDAO = new UserDAO();
        for (int i = 0; i <= 5; i++) {
            UserEO user = new UserEO();
            user.setFirstName(Lex.randomFirstName());
            user.setLastName(Lex.randomLastName());
            user.setEmail(user.getFirstName().toLowerCase() + "." + user.getLastName().toLowerCase() + "@xlent" + "." + "se");
            userDAO.add(user);
        }
    }

    public static void generateResources(){
        ResourceDAO resourceDAO = new ResourceDAO();
        for (int i = 0; i<= 20; i++) {
            ResourceEO resourceEO = new ResourceEO();
            resourceEO.setStatus(ResourceStatus.AVAILABLE);
            resourceEO.setArtNum(Lex.randomArtNum());
            resourceEO.setDescription(Lex.randomItem());
            resourceDAO.add(resourceEO);
        }
    }
}
