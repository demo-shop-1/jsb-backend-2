package demo.jsb2.modules.products.adapters.dto;

import lombok.Data;

@Data
public class ProductUpdateRequestDTO {
    private String name;
    private Integer categoryId;
    private String description;
    private Double unitPrice;
    private String imageUrl;
    private Integer unitsInStock;
    private Boolean isActive;
}
