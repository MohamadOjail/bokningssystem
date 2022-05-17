package se.ya.bokningssystem.backend.entity;

import lombok.Getter;
import lombok.Setter;
import se.ya.bokningssystem.backend.entity.enums.BorrowStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Setter
@Getter
@NamedQueries(
        {
                @NamedQuery(name = "get_by_first_or_last_name",
                        query = "FROM UserEO u WHERE u.firstName LIKE :input OR u.lastName LIKE :input"),
                @NamedQuery(name = "get_by_state",
                        query = "FROM UserEO u WHERE u.state = :input")
        }
)
public class UserEO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private  String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name="borrower_status", nullable = false)
    private BorrowStatus state;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<BookingEO> bookings = new ArrayList<>();

    // Utility Methods
    public void addBooking(BookingEO bookingEO){
        this.bookings.add(bookingEO);
    }

    public void removeBooking(BookingEO bookingEO){
        this.bookings.remove(bookingEO);
    }

    public void clearBookings(){
        this.bookings.clear();
    }

}