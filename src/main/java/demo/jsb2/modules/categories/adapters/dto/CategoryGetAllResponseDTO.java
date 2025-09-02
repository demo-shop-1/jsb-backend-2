package demo.jsb2.modules.categories.adapters.dto;

import java.util.List;

import lombok.Data;

@Data
public class CategoryGetAllResponseDTO {
    private List<CategoryGetOneResponseDTO> content;

}
