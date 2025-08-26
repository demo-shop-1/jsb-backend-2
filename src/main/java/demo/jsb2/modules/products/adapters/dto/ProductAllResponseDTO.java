package demo.jsb2.modules.products.adapters.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductAllResponseDTO {
    private List<ProductSingleResponseDTO> content;
    private int page;
    private int totalPages;
    private int size;
    private long totalElements;
}
