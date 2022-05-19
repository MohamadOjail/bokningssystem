package se.ya.bokningssystem.backend.util;

import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.Notification;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.BookingNamedQueries;

import java.util.ArrayList;
import java.util.List;

public class Notify {
    public Notify(UserEO userEO) {
        this.userEO = userEO;
        checkUserBookings();
    }

    private final UserEO userEO;
    private final List<Notification> notifications = new ArrayList<>();

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void clearNotifications() {
        this.notifications.clear();
        checkUserBookings();
    }

    public boolean notificationIsEmpty(){
        return this.notifications.isEmpty();
    }

    private void checkUserBookings(){
        BookingDAO bookingDAO = new BookingDAO();
        List<BookingEO> userOverdueBookings = bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_OVERDUE_BY_USER.queryName, userEO);
        for (BookingEO bookingEO : userOverdueBookings){
            notifications.add(new Notification(bookingEO));
        }
    }
}
