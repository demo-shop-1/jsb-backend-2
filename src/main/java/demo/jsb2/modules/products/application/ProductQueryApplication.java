package demo.jsb2.modules.products.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import demo.jsb2.modules.products.adapters.db.ProductSpecifications;
import demo.jsb2.modules.products.adapters.entity.ProductEntity;
import demo.jsb2.modules.products.domain.enums.ProductMessageEnum;
import demo.jsb2.modules.products.domain.exceptions.ProductQueryException;
import demo.jsb2.modules.products.domain.models.ProductModel;
import demo.jsb2.modules.products.domain.ports.out.ProductQueryOutRepository;
import demo.jsb2.modules.products.domain.services.ProductQueryService;
import demo.jsb2.modules.products.domain.utils.ProductUtil;
import demo.jsb2.utils.AppObjectUtil;
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

        if (AppObjectUtil.isBlankString(sku)) {
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

    @Override
    public Page<ProductModel> findAllPageable(Integer page, Integer size, Integer category)
            throws ProductQueryException {
        startMethod("findAllPageable");

        Pageable pageable = PageRequest.of(page, size);
        Specification<ProductEntity> specification = Specification.unrestricted();

        // Add filter categoryId
        if (!AppObjectUtil.isNull(category)) {
            specification = specification.and(ProductSpecifications.hasCategoryId(category));
        }

        infoMethod("findAllPageable", String.format("Page request. Page: %d, Size: %d, CategoryID: %s",
                page, size, AppObjectUtil.isNull(category) ? "none" : category));

        endMethod("findAllPageable");
        return productQueryRepository.findAllPageable(specification, pageable);
    }

}
