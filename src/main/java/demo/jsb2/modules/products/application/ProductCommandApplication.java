package demo.jsb2.modules.products.application;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import demo.jsb2.modules.products.domain.enums.ProductMessageEnum;
import demo.jsb2.modules.products.domain.models.ProductModel;
import demo.jsb2.modules.products.domain.ports.out.ProductCommandOutRepository;
import demo.jsb2.modules.products.domain.services.ProductCommandService;
import demo.jsb2.modules.products.domain.services.ProductQueryService;
import demo.jsb2.modules.products.domain.services.ProductValidationService;
import demo.jsb2.modules.products.domain.utils.ProductUtil;
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
    public ProductModel createProduct(ProductModel product) {
        startMethod("createProduct");

        // Validate unique SKU here
        ProductModel productFound = productQueryApplication.findBySku(product.getSku());
        if (productFound != null) {
            infoMethod("createProduct", String.format("Already exists this SKU: %s", product.getSku()));
            ProductUtil.throwValidationError(ProductMessageEnum.SKU_REPEATED);
        }

        // rest of validations
        productValidationService.isValidForSave(product);

        infoMethod("createProduct", String.format("Creating product with SKU: %s", product.getSku()));

        // Set variables of product
        product.setId(null);
        product.setIsActive(true);
        product.setDateCreated(LocalDateTime.now());

        endMethod("createProduct");
        return productCommandRepository.saveOne(product);
    }

    @Override
    public ProductModel updateProduct(ProductModel product) {
        startMethod("updateProduct");

        // validate SKU
        // validate rest of fields

        endMethod("updateProduct");
    }

}
