package demo.jsb2.modules.categories.adapters.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Name is required")
    @Size(min = 4, message = "Name minimum 4 characters")
    @Column(name = "name", nullable = false, length = 500)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @NotNull(message = "IsActive is required")
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @NotNull(message = "Date Created is required")
    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "last_updated", nullable = true)
    private LocalDateTime lastUpdated;
}
