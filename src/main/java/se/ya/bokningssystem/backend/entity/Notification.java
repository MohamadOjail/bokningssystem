package se.ya.bokningssystem.backend.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Notification {

    private Long bookingId;
    private String resource;
    private String resourceArtNum;
    private LocalDate returnDate;

    public Notification(BookingEO bookingEO) {
        this.bookingId = bookingEO.getId();
        this.resource = bookingEO.getResource().getDescription();
        this.resourceArtNum = bookingEO.getResource().getArtNum();
        this.returnDate = bookingEO.getReturnDate();
    }

    public Notification() {}

}
