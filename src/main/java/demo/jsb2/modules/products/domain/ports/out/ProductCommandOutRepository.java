package demo.jsb2.modules.products.domain.ports.out;

import demo.jsb2.modules.products.domain.models.ProductModel;

public interface ProductCommandOutRepository {
    ProductModel saveOne(ProductModel product);
    Boolean deleteOne(Long id);
}
