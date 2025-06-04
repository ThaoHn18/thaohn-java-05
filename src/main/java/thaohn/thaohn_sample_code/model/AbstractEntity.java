package thaohn.thaohn_sample_code.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at")
    Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updated_at")
    Date updatedAt;
}
