package se.ya.bokningssystem.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "booking_ids")
    private String bookingIds; // enkelt sätt att lagra id, ex: 1,2,3,4,5,6 ...

//    @Override
//    public String toString() {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
//        String heading = "Rapport #: " + this.id + " Datum: " + this.reportDate.format(dtf);
//        String body = "";
//        for (BookingEO bookingEO : getBookings()){
//
//        }
//        return "Report{" +
//                "id=" + id +
//                ", reportDate=" + reportDate +
//                ", bookingIds='" + bookingIds + '\'' +
//                '}';
//    }

    private List<BookingEO> getBookings(){
//        BookingDAO bookingDAO = new BookingDAO();
//        List<BookingEO> bookings = new ArrayList<>();
//        String[] ids = this.bookingIds.split(",");
//        for (String foundId : ids){
//            long id = Long.parseLong(foundId);
//            bookings.add(bookingDAO.getById(id));
//        }
        return null;
    }
}
