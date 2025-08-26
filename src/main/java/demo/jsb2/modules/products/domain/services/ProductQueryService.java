package demo.jsb2.modules.products.domain.services;

import org.springframework.data.domain.Page;

import demo.jsb2.modules.products.domain.exceptions.ProductQueryException;
import demo.jsb2.modules.products.domain.models.ProductModel;

public interface ProductQueryService {
    ProductModel findBySku(String sku) throws ProductQueryException;

    ProductModel getOneProduct(String sku) throws ProductQueryException;

    Page<ProductModel> findAllPageable(Integer page, Integer size, Integer category) throws ProductQueryException;
}
