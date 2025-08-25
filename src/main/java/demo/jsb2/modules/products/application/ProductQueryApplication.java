package demo.jsb2.modules.products.application;

import org.springframework.stereotype.Service;

import demo.jsb2.modules.products.domain.ProductMessageEnum;
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
    public ProductModel findBySku(String sku) {
        startMethod("findBySku");

        if (ObjectUtil.isBlankString(sku)) {
            ProductUtil.throwQueryError(ProductMessageEnum.SKU_BLANK);
        }

        endMethod("findBySku");
        return productQueryRepository.findOneBySku(sku).orElse(null);
    }

}
