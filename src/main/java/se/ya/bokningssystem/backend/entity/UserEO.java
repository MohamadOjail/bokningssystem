package se.ya.bokningssystem.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Setter
@Getter
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
