package demo.jsb2.modules.products.domain.ports.out;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import demo.jsb2.modules.products.domain.models.ProductModel;

public interface ProductQueryOutRepository {
    Optional<ProductModel> findOneBySku(String sku);

    Page<ProductModel> findAllPageable(Object spec, Pageable page);
}
