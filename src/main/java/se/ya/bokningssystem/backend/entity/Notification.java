package se.ya.bokningssystem.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "bookingId: " + bookingId +
                ", artNum: " + resourceArtNum +
                ", resource: " + resource +
                ", return date: " + returnDate;
    }
}
