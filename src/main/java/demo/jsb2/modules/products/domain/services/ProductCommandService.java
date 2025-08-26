package demo.jsb2.modules.products.domain.services;

import demo.jsb2.modules.products.domain.exceptions.ProductValidationException;
import demo.jsb2.modules.products.domain.models.ProductModel;

public interface ProductCommandService {
    ProductModel createOneProduct(ProductModel product) throws ProductValidationException;

    ProductModel updateOneProduct(ProductModel product) throws ProductValidationException;

    Boolean deleteOneProduct(String sku) throws ProductValidationException;

}
