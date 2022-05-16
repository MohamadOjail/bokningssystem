package se.ya.bokningssystem.backend.entity;

import lombok.Getter;
import lombok.Setter;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "booking")
@Setter
@Getter
@NamedQuery(name = "byUser", query = "FROM BookingEO c WHERE c.user= :user ")
@NamedQuery(name = "byResource", query = "FROM BookingEO c WHERE c.resource = :resource")
@NamedQuery(name = "byStatus", query = "FROM BookingEO c WHERE c.status = :status")
public class BookingEO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "user_id")
    private UserEO user;

    @OneToOne
    @JoinColumn(referencedColumnName = "resource_id")
    private ResourceEO resource;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    @Column(name = "reminder_date", nullable = false)
    private LocalDate reminderDate;

    @Column(name = "actual_return_date", nullable = false)
    private LocalDate actualReturnDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status", nullable = false)
    private BookingStatus status;

}
