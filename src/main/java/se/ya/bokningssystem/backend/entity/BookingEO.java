package se.ya.bokningssystem.backend.entity;

import lombok.Getter;
import lombok.Setter;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Setter
@Getter
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

    private LocalDateTime startDate;
    private LocalDateTime returnDate;
    private LocalDateTime reminderDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}
