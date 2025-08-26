package demo.jsb2.modules.products.application.validations;

import org.springframework.stereotype.Service;

import demo.jsb2.modules.categories.domain.models.CategoryModel;
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
        Boolean isValid = true;

        // validate sku
        validateSKU(product.getSku());

        // validate name
        validateName(product.getName());

        // validate category
        validateCategory(product.getCategory());

        // The rest of validations will be validate for ProductAspect
        return isValid;
    }

    @Override
    public Boolean existThisCategory(Integer id) {
        return categoryQueryApplication.existThisCategory(id);
    }

    @Override
    public Boolean validateSKU(String sku) throws ProductValidationException {
        Boolean isValid = true;

        if (ObjectUtil.isBlankString(sku)) {
            ProductUtil.throwValidationError(ProductMessageEnum.SKU_BLANK);
        }
        if (sku.length() < ProductIntegerEnum.SKU_MIN_SIZE.value) {
            ProductUtil.throwValidationError(ProductMessageEnum.SKU_MIN);
        }

        return isValid;
    }

    @Override
    public Boolean validateName(String name) throws ProductValidationException {
        Boolean isValid = true;

        if (ObjectUtil.isBlankString(name)) {
            ProductUtil.throwValidationError(ProductMessageEnum.NAME_BLANK);
        }

        return isValid;
    }

    @Override
    public Boolean validateCategory(CategoryModel category) throws ProductValidationException {
        Boolean isValid = true;

        if (category.getId() == null) {
            ProductUtil.throwValidationError(ProductMessageEnum.CATEGORY_NULL);
        }
        Boolean existThisCategory = this.existThisCategory(category.getId());
        infoMethod("validateCategory", String.format("Exist this category? %s", existThisCategory));
        if (!existThisCategory) {
            ProductUtil.throwValidationError(ProductMessageEnum.CATEGORY_NOT_EXIST);
        }

        return isValid;
    }

}
