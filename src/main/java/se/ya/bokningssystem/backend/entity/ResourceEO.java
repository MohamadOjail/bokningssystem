package se.ya.bokningssystem.backend.entity;

import lombok.Getter;
import lombok.Setter;
import se.ya.bokningssystem.backend.entity.enums.state;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "resource")
@Setter
@Getter
public class ResourceEO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_id")
    private long id;

    @Column(name = "art_number", nullable = false)
    private String artNum;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private state status;

    private LocalDate availableDate;
}
