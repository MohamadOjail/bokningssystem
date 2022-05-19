package se.ya.bokningssystem;

import se.ya.bokningssystem.backend.dao.ReportDAO;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.Notification;
import se.ya.bokningssystem.backend.entity.ReportEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.UserNamedQueries;
import se.ya.bokningssystem.backend.util.Notify;

public class MainConsole {
    public static void main(String[] args) {

//        DummyData.generateUsers();
//        DummyData.generateResources();
//        DummyData.generateBookings();
//
//        ReportDAO reportDAO = new ReportDAO();
//        ReportEO reportEO = new ReportEO();
//        reportEO.setBookingIds(3L);
//        ReportEO add = reportDAO.add(reportEO);
//        System.out.println(add.getBookingIds());


        UserDAO userDAO = new UserDAO();
//        userDAO.delete(1L);
        UserEO userEO = userDAO.getById(3L);
        Notify notify = new Notify(userEO);

        for (Notification notification : notify.getNotifications()){
            System.out.println(notification);
        }

    }
}
