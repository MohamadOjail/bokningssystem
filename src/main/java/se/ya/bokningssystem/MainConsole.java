package se.ya.bokningssystem;

import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.dao.ReportDAO;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ReportEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.enums.BookingNamedQueries;
import se.ya.bokningssystem.backend.entity.enums.ResourceNamedQueries;

import java.util.ArrayList;
import java.util.List;

public class MainConsole {
    public static void main(String[] args) {

//        DummyData.generateUsers();
//        DummyData.generateResources();
//        DummyData.generateBookings();
//        BookingDAO bookingDAO = new BookingDAO();
//
//        List<BookingEO> eos = bookingDAO.getListByNamedQuery(
//                BookingNamedQueries.GET_OVERDUE.queryName
//        );
//        ReportEO eo = new ReportEO();
//        eo.getOverduedBookings().addAll(eos);
        ReportDAO reportDAO = new ReportDAO();
        ReportEO byId = reportDAO.getById(2L);


        for (BookingEO temp : byId.getOverduedBookings()){
            if (temp.getUser().getId()== 6L){
                System.out.println(temp.getResource().getDescription() + " " + temp.getUser().getId());
            }
        }

    }
}
