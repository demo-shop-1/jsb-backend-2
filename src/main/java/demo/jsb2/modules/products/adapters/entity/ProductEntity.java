package demo.jsb2.modules.products.adapters.entity;

import java.time.LocalDateTime;

import demo.jsb2.modules.categories.adapters.entities.CategoryEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "SKU is required")
    @Size(min = 4, message = "SKU minimum 4 characters")
    @Column(name = "sku", nullable = false, length = 255)
    private String sku;

    @NotEmpty(message = "Name is required")
    @Column(name = "name", nullable = false, length = 500)
    private String name;

    @NotNull(message = "Category ID is required")
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @NotEmpty(message = "Description is required")
    @Column(name = "description", nullable = false, length = 2000)
    private String description;

    @Column(name = "image_url", nullable = true, length = 255)
    private String imageUrl;

    @NotNull(message = "Unit Price is required")
    @Min(value = 0, message = "Unit Price minimum value is 0")
    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @NotNull(message = "Active is required")
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @NotNull(message = "Units In Stock is required")
    @Min(value = 0, message = "Units In Stock minimum value is 0")
    @Column(name = "units_in_stock", nullable = false)
    private Integer unitsInStock;

    @NotNull(message = "Date Created is required")
    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "last_updated", nullable = true)
    private LocalDateTime lastUpdated;
}
