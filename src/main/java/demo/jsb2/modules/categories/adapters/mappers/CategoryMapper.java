package demo.jsb2.modules.categories.adapters.mappers;

import demo.jsb2.modules.categories.adapters.dto.CategoryCreateRequestDTO;
import demo.jsb2.modules.categories.adapters.dto.CategoryCreateResponseDTO;
import demo.jsb2.modules.categories.adapters.entities.CategoryEntity;
import demo.jsb2.modules.categories.domain.models.CategoryModel;

public class CategoryMapper {

    public static CategoryEntity toCategoryEntity(CategoryModel request) {
        CategoryEntity result = new CategoryEntity();
        result.setId(request.getId());
        result.setName(request.getName());
        result.setDescription(request.getDescription());
        result.setIsActive(request.getIsActive());
        result.setDateCreated(request.getDateCreated());
        result.setLastUpdated(request.getLastUpdated());

        return result;
    }

    public static CategoryModel toCategoryModel(CategoryCreateRequestDTO request) {
        CategoryModel result = new CategoryModel();
        result.setId(request.getId());
        result.setName(request.getName());
        result.setDescription(request.getDescription());
        return result;
    }

    public static CategoryModel toCategoryModel(CategoryEntity request) {
        CategoryModel result = new CategoryModel();
        result.setId(request.getId());
        result.setName(request.getName());
        result.setDescription(request.getDescription());
        result.setIsActive(request.getIsActive());
        result.setDateCreated(request.getDateCreated());
        result.setLastUpdated(request.getLastUpdated());

        return result;
    }

    public static CategoryCreateResponseDTO toCategoryCreateResponseDTO(CategoryModel request) {
        CategoryCreateResponseDTO result = new CategoryCreateResponseDTO();
        result.setId(request.getId());
        result.setDescription(request.getDescription());
        result.setName(request.getName());
        result.setIsActive(request.getIsActive());

        return result;
    }
}
