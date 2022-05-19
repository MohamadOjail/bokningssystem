package se.ya.bokningssystem.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.Query;
import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.dao.ReportDAO;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.enums.BookingNamedQueries;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "report")
@Getter
@Setter
@NamedQuery(name = "tt", query = "FROM BookingEO b WHERE b.status = 'OVERDUE' AND b.user = :input")
public class ReportEO implements Serializable {

    public ReportEO() {
        this.reportDate = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Setter(AccessLevel.NONE)
    @Column(name = "booking_ids")
    private String bookingIds; // enkelt sätt att lagra id, ex: 1,2,3,4,5,6 ...

    private List<BookingEO> getOverdueBookings(){
        List<BookingEO> output = new ArrayList<>();
        BookingDAO bookingDAO = new BookingDAO();
        output.addAll(bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_OVERDUE.queryName));
        return output;
    }
    private List<BookingEO> getOverdueBookings(Long userId){
        List<BookingEO> output = new ArrayList<>();
        BookingDAO bookingDAO = new BookingDAO();
        UserDAO userDAO = new UserDAO();
        UserEO userEO = userDAO.getById(userId);
        output.addAll(bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_OVERDUE_BY_USER.queryName, userEO));
        return output;
    }
    public void setBookingIds(){
        BookingDAO bookingDAO = new BookingDAO();
        bookingDAO.recheckStatus();
        this.bookingIds = extractIds(getOverdueBookings());
    }

    public void setBookingIds(Long userId){
        BookingDAO bookingDAO = new BookingDAO();
        bookingDAO.recheckStatus();
        this.bookingIds = extractIds(getOverdueBookings(userId));
    }

    private String extractIds(List<BookingEO> bookings){
        String output = "";
        int index = 0;
        for (BookingEO bookingEO : bookings){
            index = bookings.indexOf(bookingEO);
            if (index == bookings.size() -1) output += bookingEO.getId();
            else output += bookingEO.getId() + ",";
        }
        return output;
    }
}
