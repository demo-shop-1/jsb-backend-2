package demo.jsb2.modules.products.application.validations;

import org.springframework.stereotype.Service;

import demo.jsb2.modules.categories.domain.services.CategoryQueryService;
import demo.jsb2.modules.products.application.ProductApplication;
import demo.jsb2.modules.products.domain.enums.ProductIntegerEnum;
import demo.jsb2.modules.products.domain.enums.ProductMessageEnum;
import demo.jsb2.modules.products.domain.exceptions.ProductValidationException;
import demo.jsb2.modules.products.domain.models.ProductModel;
import demo.jsb2.modules.products.domain.services.ProductValidationService;
import demo.jsb2.modules.products.domain.utils.ProductUtil;
import demo.jsb2.utils.ObjectUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductValidationApplication extends ProductApplication implements ProductValidationService {
    private final CategoryQueryService categoryQueryApplication;

    @PostConstruct
    public void init() {
        nameClass = "ProductValidationApplication";
    }

    @Override
    public Boolean isValidForSave(ProductModel product) throws ProductValidationException {
        startMethod("isValidForSave");
        Boolean isValid = true;

        // validate sku
        if (ObjectUtil.isBlankString(product.getSku())) {
            ProductUtil.throwValidationError(ProductMessageEnum.SKU_BLANK);
        }
        if (product.getSku().length() < ProductIntegerEnum.SKU_MIN_SIZE.value) {
            ProductUtil.throwValidationError(ProductMessageEnum.SKU_MIN);
        }

        // validate name
        if (ObjectUtil.isBlankString(product.getName())) {
            ProductUtil.throwValidationError(ProductMessageEnum.NAME_BLANK);
        }

        // validate category
        if (product.getCategory().getId() == null) {
            ProductUtil.throwValidationError(ProductMessageEnum.CATEGORY_NULL);
        }
        Boolean existThisCategory = this.existThisCategory(product.getCategory().getId());
        infoMethod("isValidForSave", String.format("Exist this category? %s", existThisCategory));
        if (!existThisCategory) {
            ProductUtil.throwValidationError(ProductMessageEnum.CATEGORY_NOT_EXIST);
        }

        // The rest of validations will be validate for ProductAspect
        endMethod("isValidForSave");
        return isValid;
    }

    @Override
    public Boolean existThisCategory(Integer id) {
        return categoryQueryApplication.existThisCategory(id);
    }

}
