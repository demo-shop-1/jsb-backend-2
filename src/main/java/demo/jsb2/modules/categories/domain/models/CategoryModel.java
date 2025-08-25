package demo.jsb2.modules.categories.domain.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel {
    private Integer id;
    private String name;
    private String description;
    private Boolean isActive;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
