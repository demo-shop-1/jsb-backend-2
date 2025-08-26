package demo.jsb2.modules.products.adapters.mappers;

import org.springframework.data.domain.Page;

import demo.jsb2.modules.categories.adapters.mappers.CategoryMapper;
import demo.jsb2.modules.categories.domain.models.CategoryModel;
import demo.jsb2.modules.products.adapters.dto.ProductAllResponseDTO;
import demo.jsb2.modules.products.adapters.dto.ProductCreateRequestDTO;
import demo.jsb2.modules.products.adapters.dto.ProductCreateResponseDTO;
import demo.jsb2.modules.products.adapters.dto.ProductSingleResponseDTO;
import demo.jsb2.modules.products.adapters.dto.ProductUpdateRequestDTO;
import demo.jsb2.modules.products.adapters.dto.ProductUpdateResponseDTO;
import demo.jsb2.modules.products.adapters.entity.ProductEntity;
import demo.jsb2.modules.products.domain.models.ProductModel;
import demo.jsb2.utils.AppObjectUtil;

public class ProductMapper {

    public static ProductEntity toProductEntity(ProductModel request) {
        ProductEntity result = new ProductEntity();
        result.setId(request.getId());
        result.setSku(request.getSku());
        result.setName(request.getName());
        result.setCategory(CategoryMapper.toCategoryEntity(request.getCategory()));
        result.setDescription(request.getDescription());
        result.setIsActive(request.getIsActive());
        result.setUnitPrice(request.getUnitPrice());
        result.setImageUrl(request.getImageUrl());
        result.setUnitsInStock(request.getUnitsInStock());
        result.setDateCreated(request.getDateCreated());
        result.setLastUpdated(request.getLastUpdated());

        return result;
    }

    public static ProductModel toProductModel(ProductEntity request) {
        ProductModel result = new ProductModel();
        result.setId(request.getId());
        result.setSku(request.getSku());
        result.setName(request.getName());
        result.setCategory(CategoryMapper.toCategoryModel(request.getCategory()));
        result.setDescription(request.getDescription());
        result.setImageUrl(request.getImageUrl());
        result.setIsActive(request.getIsActive());
        result.setUnitPrice(request.getUnitPrice());
        result.setUnitsInStock(request.getUnitsInStock());
        result.setDateCreated(request.getDateCreated());
        result.setLastUpdated(request.getLastUpdated());

        return result;
    }

    public static ProductModel toProductModel(ProductCreateRequestDTO request) {
        ProductModel result = new ProductModel();
        result.setSku(request.getSku());
        result.setName(request.getName());

        CategoryModel category = new CategoryModel();
        category.setId(request.getCategoryId());
        result.setCategory(category);

        result.setDescription(request.getDescription());
        result.setUnitPrice(request.getUnitPrice());
        result.setImageUrl(request.getImageUrl());
        result.setUnitsInStock(request.getUnitsInStock());

        return result;
    }

    public static ProductCreateResponseDTO toProductCreateResponseDTO(ProductModel request) {
        ProductCreateResponseDTO result = new ProductCreateResponseDTO();
        result.setSku(request.getSku());
        result.setName(request.getName());
        result.setCategoryId(request.getCategory().getId());
        result.setDescription(request.getDescription());
        result.setUnitPrice(request.getUnitPrice());
        result.setImageUrl(request.getImageUrl());
        result.setUnitsInStock(request.getUnitsInStock());
        result.setIsActive(request.getIsActive());
        result.setDateCreated(request.getDateCreated().format(AppObjectUtil.getFormatterLocalDateTimeDefault()));

        return result;
    }

    public static ProductModel toProductModel(ProductUpdateRequestDTO request) {
        ProductModel result = new ProductModel();
        result.setName(request.getName());

        if (request.getCategoryId() != null) {
            CategoryModel category = new CategoryModel();
            category.setId(request.getCategoryId());
            result.setCategory(category);
        }

        result.setDescription(request.getDescription());
        result.setUnitPrice(request.getUnitPrice());
        result.setImageUrl(request.getImageUrl());
        result.setUnitsInStock(request.getUnitsInStock());

        return result;
    }

    public static ProductUpdateResponseDTO toProductUpdateResponseDTO(ProductModel request) {
        ProductUpdateResponseDTO result = new ProductUpdateResponseDTO();
        result.setName(request.getName());
        result.setCategoryId(request.getCategory().getId());
        result.setDescription(request.getDescription());
        result.setUnitPrice(request.getUnitPrice());
        result.setImageUrl(request.getImageUrl());
        result.setUnitsInStock(request.getUnitsInStock());
        result.setIsActive(request.getIsActive());
        result.setLastUpdated(request.getLastUpdated().format(AppObjectUtil.getFormatterLocalDateTimeDefault()));

        return result;
    }

    public static ProductSingleResponseDTO toProductSingleResponseDTO(ProductModel request) {
        ProductSingleResponseDTO result = new ProductSingleResponseDTO();
        result.setSku(request.getSku());
        result.setName(request.getName());
        result.setCategoryId(request.getCategory().getId());
        result.setDescription(request.getDescription());
        result.setUnitPrice(request.getUnitPrice());
        result.setImageUrl(request.getImageUrl());
        result.setUnitsInStock(request.getUnitsInStock());
        result.setIsActive(request.getIsActive());
        return result;
    }

    public static ProductAllResponseDTO toProductAllResponseDTO(Page<ProductModel> request) {
        ProductAllResponseDTO result = new ProductAllResponseDTO();
        result.setContent(request
                .getContent()
                .stream()
                .map(ProductMapper::toProductSingleResponseDTO)
                .toList());
        result.setPage(request.getNumber());
        result.setTotalPages(request.getTotalPages());
        result.setSize(request.getSize());
        result.setTotalElements(request.getTotalElements());

        return result;
    }
}
