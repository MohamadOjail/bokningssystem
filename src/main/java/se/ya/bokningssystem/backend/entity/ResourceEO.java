package se.ya.bokningssystem.backend.entity;

import lombok.Getter;
import lombok.Setter;
import se.ya.bokningssystem.backend.entity.enums.ResourceStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "resource")
@Setter
@Getter
@NamedQueries(
        {
                @NamedQuery(name = "get_by_art_num",
                        query = "FROM ResourceEO r WHERE r.artNum LIKE :input"),
                @NamedQuery(name = "get_by_description",
                        query = "FROM ResourceEO r WHERE r.description LIKE :input"),
                @NamedQuery(name = "get_by_status",
                        query = "FROM ResourceEO r WHERE r.status = :input")
        }
)
public class ResourceEO implements Serializable {
    public ResourceEO() {
        this.availableDate = LocalDate.now();
    }

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
    private ResourceStatus status;

    private LocalDate availableDate;
}
