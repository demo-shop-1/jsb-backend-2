package demo.jsb2.modules.categories.adapters.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CategoryCreateRequestDTO extends CategoryDTO {
    private String description;
}
