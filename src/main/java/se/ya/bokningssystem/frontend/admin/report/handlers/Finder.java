package se.ya.bokningssystem.frontend.admin.report.handlers;

import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.BookingNamedQueries;
import se.ya.bokningssystem.frontend.admin.report.ReportController;

import java.util.List;

public class Finder {
    private final BookingDAO bookingDAO = new BookingDAO();
    private final ResourceDAO resourceDAO = new ResourceDAO();
    private final ReportController rc;

    public Finder(ReportController rc) {
        this.rc = rc;
    }

    public void populateByUser(UserEO userEO){
        List<BookingEO> list = bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_OVERDUE_BY_USER.queryName, userEO);
        rc.getBookingEOS().clear();
        rc.getBookingEOS().addAll(list);
        getUsers(list);
        getResorces(list);


    }

    public void populateByResource(ResourceEO resourceEO){
        List<BookingEO> list = bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_OVERDUE_BY_RESOURCE.queryName, resourceEO);
        rc.getBookingEOS().clear();
        rc.getBookingEOS().addAll(bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_OVERDUE_BY_RESOURCE.queryName, resourceEO));
        getUsers(list);
        getResorces(list);

    }
    public void populateNoFilter(){
        List<BookingEO> bookList = bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_OVERDUE.queryName);
        rc.getBookingEOS().clear();
        rc.getBookingEOS().addAll(bookList);
        getUsers(bookList);
        getResorces(bookList);

    }

    private void getUsers(List<BookingEO>bookings){
//        rc.getUsers().clear();
        bookings.forEach(b-> rc.getUsers().add(b.getUser()));


    }

    private void getResorces(List<BookingEO>bookings){
        rc.getResources().clear();
        bookings.forEach(b-> rc.getResources().add(b.getResource()));


    }
}
