package demo.jsb2.modules.products.domain.ports.out;

import java.util.Optional;

import demo.jsb2.modules.products.domain.models.ProductModel;

public interface ProductQueryOutRepository {
    Optional<ProductModel> findOneBySku(String sku);
}
