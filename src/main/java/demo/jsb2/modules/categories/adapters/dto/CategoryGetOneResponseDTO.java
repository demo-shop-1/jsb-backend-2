package demo.jsb2.modules.categories.adapters.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CategoryGetOneResponseDTO extends CategoryDTO {
    private String description;
    private Boolean isActive;
    private String dateCreated;
}
