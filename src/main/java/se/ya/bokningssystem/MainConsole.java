package se.ya.bokningssystem;

import se.ya.bokningssystem.backend.dao.ReportDAO;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.ReportEO;

public class MainConsole {
    public static void main(String[] args) {

        DummyData.generateUsers();
        DummyData.generateResources();
        DummyData.generateBookings();

        ReportDAO reportDAO = new ReportDAO();
        ReportEO reportEO = new ReportEO();
        reportEO.setBookingIds();
        ReportEO add = reportDAO.add(reportEO);
        System.out.println(add.getBookingIds());


//        UserDAO userDAO = new UserDAO();
//        userDAO.delete(1L);
    }
}
