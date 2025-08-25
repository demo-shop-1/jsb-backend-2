package demo.jsb2.modules.products.adapters.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.jsb2.modules.products.adapters.entity.ProductEntity;
import demo.jsb2.modules.products.adapters.mappers.ProductMapper;
import demo.jsb2.modules.products.domain.models.ProductModel;
import demo.jsb2.modules.products.domain.ports.out.ProductCommandOutRepository;

@Repository
public interface ProductCommandJpaRepository extends JpaRepository<ProductEntity, Long>, ProductCommandOutRepository {

    @Override
    default ProductModel saveOne(ProductModel product) {
        return ProductMapper.toProductModel(save(ProductMapper.toProductEntity(product)));
    }

}
