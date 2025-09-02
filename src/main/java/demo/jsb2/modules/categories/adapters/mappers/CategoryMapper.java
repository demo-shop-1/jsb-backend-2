package demo.jsb2.modules.categories.adapters.mappers;

import java.util.List;

import demo.jsb2.modules.categories.adapters.dto.CategoryCreateRequestDTO;
import demo.jsb2.modules.categories.adapters.dto.CategoryCreateResponseDTO;
import demo.jsb2.modules.categories.adapters.dto.CategoryGetAllResponseDTO;
import demo.jsb2.modules.categories.adapters.dto.CategoryGetOneResponseDTO;
import demo.jsb2.modules.categories.adapters.entities.CategoryEntity;
import demo.jsb2.modules.categories.domain.models.CategoryModel;
import demo.jsb2.utils.AppObjectUtil;

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

    public static CategoryGetOneResponseDTO toCategoryGetOneResponseDTO(CategoryModel request) {
        CategoryGetOneResponseDTO result = new CategoryGetOneResponseDTO();
        result.setId(request.getId());
        result.setDescription(request.getDescription());
        result.setName(request.getName());
        result.setIsActive(request.getIsActive());
        result.setDateCreated(request.getDateCreated().format(AppObjectUtil.getFormatterLocalDateTimeDefault()));

        return result;
    }

    public static CategoryGetAllResponseDTO CategoryGetAllResponseDTO(List<CategoryModel> request) {
        CategoryGetAllResponseDTO result = new CategoryGetAllResponseDTO();
        result.setContent(request.stream().map(CategoryMapper::toCategoryGetOneResponseDTO).toList());

        return result;
    }
}
