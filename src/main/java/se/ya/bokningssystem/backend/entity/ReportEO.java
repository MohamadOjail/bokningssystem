package se.ya.bokningssystem.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.Query;
import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.dao.ReportDAO;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.enums.BookingNamedQueries;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "report")
@Getter
@Setter

public class ReportEO implements Serializable {

    public ReportEO() {
        this.reportDate = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @OneToMany( cascade = CascadeType.DETACH, fetch = FetchType.EAGER, orphanRemoval = false)
    private List<BookingEO> overduedBookings = new ArrayList<>();

    public List<BookingEO> getByUser(UserEO user){
        return this.overduedBookings.stream().filter(x-> x.getUser().getId()==user.getId()).toList();
    }




}
