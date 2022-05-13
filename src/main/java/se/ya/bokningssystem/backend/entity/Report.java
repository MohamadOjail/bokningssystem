package se.ya.bokningssystem.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReportItem> reportItems = new ArrayList<>();

    @Override
    public String toString() {
        int count = 1;
        String output = "§§ - Rapport #: " + this.id + "\nFörsenade bokningar:\n";
        for (ReportItem item : reportItems){
            output.concat(count + item.toString() + "\n");
            count++;
        }
        return output;
    }
}
