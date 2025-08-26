package demo.jsb2.modules.products.application;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import demo.jsb2.modules.products.domain.enums.ProductMessageEnum;
import demo.jsb2.modules.products.domain.exceptions.ProductValidationException;
import demo.jsb2.modules.products.domain.models.ProductModel;
import demo.jsb2.modules.products.domain.ports.out.ProductCommandOutRepository;
import demo.jsb2.modules.products.domain.services.ProductCommandService;
import demo.jsb2.modules.products.domain.services.ProductQueryService;
import demo.jsb2.modules.products.domain.services.ProductValidationService;
import demo.jsb2.modules.products.domain.utils.ProductUtil;
import demo.jsb2.utils.AppObjectUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCommandApplication extends ProductApplication implements ProductCommandService {
    private final ProductQueryService productQueryApplication;
    private final ProductCommandOutRepository productCommandRepository;
    private final ProductValidationService productValidationService;

    @PostConstruct
    public void init() {
        nameClass = "ProductCommandApplication";
    }

    @Override
    public ProductModel createOneProduct(ProductModel product) throws ProductValidationException {
        startMethod("createOneProduct");

        // Validate unique SKU here
        ProductModel productFound = productQueryApplication.findBySku(product.getSku());
        if (productFound != null) {
            infoMethod("createOneProduct", String.format("Already exists this SKU: %s", product.getSku()));
            throw ProductUtil.throwValidationError(ProductMessageEnum.SKU_REPEATED);
        }

        // rest of validations
        productValidationService.isValidForSave(product);

        infoMethod("createOneProduct", String.format("Creating product with SKU: %s", product.getSku()));

        // Set variables of product
        product.setId(null);
        product.setIsActive(true);
        product.setDateCreated(LocalDateTime.now());

        endMethod("createOneProduct");
        return productCommandRepository.saveOne(product);
    }

    @Override
    public ProductModel updateOneProduct(ProductModel product) throws ProductValidationException {
        startMethod("updateOneProduct");

        // validate SKU
        ProductModel productFound = productQueryApplication.findBySku(product.getSku());
        if (productFound == null) {
            infoMethod("updateOneProduct", String.format("Does not exist this SKU: %s", product.getSku()));
            throw ProductUtil.throwValidationError(ProductMessageEnum.SKU_NOT_EXIST);
        } else {

            // validate name
            if (product.getName() == null) {
                product.setName(productFound.getName());
            } else {
                productValidationService.validateName(product.getName());
            }

            // validate category
            if (product.getCategory() == null) {
                product.setCategory(productFound.getCategory());
            } else {
                productValidationService.validateCategory(product.getCategory());
            }

            // validate description
            if (product.getDescription() == null) {
                product.setDescription(productFound.getDescription());
            }

            // validate image_url
            if (AppObjectUtil.isNull(product.getImageUrl())) {
                product.setImageUrl(productFound.getImageUrl());
            }

            // validate unit_price
            if (AppObjectUtil.isNull(product.getUnitPrice())) {
                product.setUnitPrice(productFound.getUnitPrice());
            }

            // validate is_active
            if (AppObjectUtil.isNull(product.getIsActive())) {
                product.setIsActive(productFound.getIsActive());
            }

            // validate units in stock
            if (AppObjectUtil.isNull(product.getUnitsInStock())) {
                product.setUnitsInStock(productFound.getUnitsInStock());
            }

            // set audit fields
            product.setId(productFound.getId());
            product.setDateCreated(productFound.getDateCreated());
            product.setLastUpdated(LocalDateTime.now());
        }

        endMethod("updateOneProduct");
        return productCommandRepository.saveOne(product);
    }

    @Override
    public Boolean deleteOneProduct(String sku) throws ProductValidationException {
        startMethod("deleteOneProduct");
        // validate SKU
        ProductModel productFound = productQueryApplication.findBySku(sku);
        if (productFound == null) {
            infoMethod("deleteOneProduct", String.format("Does not exist this SKU: %s", sku));
            throw ProductUtil.throwValidationError(ProductMessageEnum.SKU_NOT_EXIST);
        }
        endMethod("deleteOneProduct");
        return productCommandRepository.deleteOne(productFound.getId());
    }

}
