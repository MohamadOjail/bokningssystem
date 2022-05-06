package se.ya.bokningssystem.backend.entity;

import lombok.Getter;
import lombok.Setter;
import se.ya.bokningssystem.backend.entity.enums.Availability;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "resource")
@Setter
@Getter
public class ResourceEO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_id")
    private long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private Availability status;

    private LocalDateTime availableDate = status == Availability.AVAILABLE ? LocalDateTime.now() : null;
}
