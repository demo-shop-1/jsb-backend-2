package demo.jsb2.modules.products.domain.services;

import demo.jsb2.modules.products.domain.models.ProductModel;

public interface ProductCommandService {
    ProductModel createProduct(ProductModel product);
}
