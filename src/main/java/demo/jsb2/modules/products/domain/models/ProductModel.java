package demo.jsb2.modules.products.domain.models;

import java.time.LocalDateTime;

import demo.jsb2.modules.categories.domain.models.CategoryModel;
import lombok.Data;

@Data
public class ProductModel {
    private Long id;
    private String sku;
    private String name;
    private CategoryModel category;
    private String description;
    private Double unitPrice;
    private String imageUrl;
    private Boolean isActive;
    private Integer unitsInStock;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
