package demo.jsb2.modules.products.application;

import org.springframework.stereotype.Service;

import demo.jsb2.modules.products.domain.enums.ProductMessageEnum;
import demo.jsb2.modules.products.domain.exceptions.ProductQueryException;
import demo.jsb2.modules.products.domain.models.ProductModel;
import demo.jsb2.modules.products.domain.ports.out.ProductQueryOutRepository;
import demo.jsb2.modules.products.domain.services.ProductQueryService;
import demo.jsb2.modules.products.domain.utils.ProductUtil;
import demo.jsb2.utils.ObjectUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductQueryApplication extends ProductApplication implements ProductQueryService {
    private final ProductQueryOutRepository productQueryRepository;

    @PostConstruct
    public void init() {
        nameClass = "ProductQueryApplication";
    }

    @Override
    public ProductModel findBySku(String sku) throws ProductQueryException {
        startMethod("findBySku");

        if (ObjectUtil.isBlankString(sku)) {
            ProductUtil.throwQueryError(ProductMessageEnum.SKU_BLANK);
        }

        endMethod("findBySku");
        return productQueryRepository.findOneBySku(sku).orElse(null);
    }

    @Override
    public ProductModel getOneProduct(String sku) throws ProductQueryException {
        startMethod("getOneProduct");

        ProductModel productFound = this.findBySku(sku);
        if (productFound == null) {
            infoMethod("getOneProduct", String.format("Does not exist this SKU: %s", sku));
            throw ProductUtil.throwQueryError(ProductMessageEnum.SKU_NOT_EXIST);
        }
        endMethod("getOneProduct");
        return productFound;
    }

}
