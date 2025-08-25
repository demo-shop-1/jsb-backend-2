package demo.jsb2.modules.products.domain.services;

import demo.jsb2.modules.products.domain.exceptions.ProductValidationException;
import demo.jsb2.modules.products.domain.models.ProductModel;

public interface ProductValidationService {
    Boolean isValidForSave(ProductModel product) throws ProductValidationException;

    Boolean existThisCategory(Integer id);
}
