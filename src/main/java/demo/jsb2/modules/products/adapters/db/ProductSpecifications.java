package demo.jsb2.modules.products.adapters.db;

import org.springframework.data.jpa.domain.Specification;

import demo.jsb2.modules.products.adapters.entity.ProductEntity;
import jakarta.persistence.criteria.Predicate;

public class ProductSpecifications {
    public static Specification<ProductEntity> hasCategoryId(Integer categoryId) {
        return (root, query, builder) -> {

            if (categoryId == null)
                return null;
            // we have to navigate into relationship
            Predicate predicate = builder.equal(root.get("category").get("id"), categoryId);
            return predicate;
        };
    }
}
