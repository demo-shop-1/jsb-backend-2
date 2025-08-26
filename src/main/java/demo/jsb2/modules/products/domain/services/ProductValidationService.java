package demo.jsb2.modules.products.domain.services;

import demo.jsb2.modules.categories.domain.models.CategoryModel;
import demo.jsb2.modules.products.domain.exceptions.ProductValidationException;
import demo.jsb2.modules.products.domain.models.ProductModel;

public interface ProductValidationService {
    Boolean isValidForUpdate(ProductModel product) throws ProductValidationException;

    Boolean isValidForSave(ProductModel product) throws ProductValidationException;

    Boolean existThisCategory(Integer id);

    Boolean validateSKU(String sku) throws ProductValidationException;

    Boolean validateName(String name) throws ProductValidationException;

    Boolean validateCategory(CategoryModel category) throws ProductValidationException;
}
