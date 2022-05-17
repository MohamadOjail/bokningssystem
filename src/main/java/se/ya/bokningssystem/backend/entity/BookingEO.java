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
@NamedQueries(
        {
                @NamedQuery(name = "by_overdue",
                        query = "FROM BookingEO b WHERE b.status = 'OVERDUE'"),
                @NamedQuery(name = "by_overdue_by_user",
                        query = "FROM BookingEO b WHERE b.status = 'OVERDUE' AND b.user = :input"),
                @NamedQuery(name = "by_user",
                        query = "FROM BookingEO b WHERE b.user = :input"),
                @NamedQuery(name = "by_resource",
                        query = "FROM BookingEO b WHERE b.resource = :input"),
                @NamedQuery(name = "by_status",
                        query = "FROM BookingEO b WHERE b.status = :input"),
        }
)
public class BookingEO implements Serializable {

    public BookingEO() {
        this.status = BookingStatus.ACTIVE;
    }

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

    @Column(name = "actual_return_date", nullable = true)
    private LocalDate actualReturnDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status", nullable = false)
    private BookingStatus status;

}
