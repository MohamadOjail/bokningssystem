package se.ya.bokningssystem.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

public class ReportItem implements Serializable {

    private long bookingId;
    private String userName;
    private String resourceArtNum;
    private String resourceDescription;
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
