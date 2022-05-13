package se.ya.bokningssystem.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class ReportItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_item_id")
    private Long id;
    @Column(name = "booking_id")
    private long bookingId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "art_num")
    private String resourceArtNum;
    @Column(name = "resource_description")
    private String resourceDescription;
    @Column(name = "return_date")
    private LocalDate returnDate;

    public ReportItem() {
    }

    public ReportItem(BookingEO bookingEO) {
        UserEO userEO = bookingEO.getUser();
        ResourceEO resourceEO = bookingEO.getResource();

        this.bookingId = bookingEO.getId();
        this.userName = userEO.getFirstName() + " " + userEO.getLastName();
        this.resourceArtNum = resourceEO.getArtNum();
        this.resourceDescription = resourceEO.getDescription();
        this.returnDate = bookingEO.getReturnDate();
    }

    @Override
    public String toString() {
        return  " - Boknings id: " + bookingId +
                ", Låntagare: " + userName +
                ", resursartnum: " + resourceArtNum +
                ", resursbeskrivning: " + resourceDescription +
                ", ska återlämnas vid: " + returnDate;
    }
}
