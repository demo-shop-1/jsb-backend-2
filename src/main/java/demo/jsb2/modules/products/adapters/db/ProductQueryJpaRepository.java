package demo.jsb2.modules.products.adapters.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demo.jsb2.modules.products.adapters.entity.ProductEntity;
import demo.jsb2.modules.products.adapters.mappers.ProductMapper;
import demo.jsb2.modules.products.domain.models.ProductModel;
import demo.jsb2.modules.products.domain.ports.out.ProductQueryOutRepository;

@Repository
public interface ProductQueryJpaRepository extends JpaRepository<ProductEntity, Long>, ProductQueryOutRepository {

    @Override
    default Optional<ProductModel> findOneBySku(String sku) {
        return queryFindOneBySku(sku).map(ProductMapper::toProductModel);
    }

    @Query("SELECT p FROM ProductEntity p WHERE LOWER(p.sku) LIKE LOWER(:sku)")
    Optional<ProductEntity> queryFindOneBySku(String sku);

}
