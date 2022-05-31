package se.ya.bokningssystem.frontend.admin.report.handlers;

import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.BookingNamedQueries;
import se.ya.bokningssystem.frontend.admin.report.ReportController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Finder {
    private final BookingDAO bookingDAO = new BookingDAO();
    private final ReportController rc;

    public Finder(ReportController rc) {
        this.rc = rc;
    }

    public void populateByUser(UserEO userEO){
        List<BookingEO> list = bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_OVERDUE_BY_USER.queryName, userEO);
        rc.getBookingEOS().clear();
        rc.getBookingEOS().addAll(list);
    }

    public void populateByResource(ResourceEO resourceEO){
        List<BookingEO> list = bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_OVERDUE_BY_RESOURCE.queryName, resourceEO);
        rc.getBookingEOS().clear();
        rc.getBookingEOS().addAll(bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_OVERDUE_BY_RESOURCE.queryName, resourceEO));
    }
    public void populateNoFilter(){
        List<BookingEO> bookList = bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_OVERDUE.queryName);
        rc.getBookingEOS().clear();
        rc.getBookingEOS().addAll(bookList);
    }

    public void getUsers(){
        rc.getUsers().clear();
        rc.getUsers().addAll(getUniqueList());
    }

    public void getResorces(){
        rc.getResources().clear();
        rc.getBookingEOS().forEach(b-> rc.getResources().add(b.getResource()));
    }

    public void reset(){
        List<BookingEO> bookList = bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_OVERDUE.queryName);
        rc.getBookingEOS().clear();
        rc.getBookingEOS().addAll(bookList);
        rc.getCb_user().getSelectionModel().select(null);
        rc.getCb_resource().getSelectionModel().select(null);

    }

    private List<UserEO> getUniqueList(){
        List<UserEO> userlist = new ArrayList<>();
        rc.getBookingEOS().forEach(u-> userlist.add(u.getUser()));
        return userlist.stream().distinct().collect(Collectors.toList());
    }
}
