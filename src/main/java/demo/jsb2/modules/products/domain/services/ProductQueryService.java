package demo.jsb2.modules.products.domain.services;

import demo.jsb2.modules.products.domain.models.ProductModel;

public interface ProductQueryService {
    ProductModel findBySku(String sku);
}
