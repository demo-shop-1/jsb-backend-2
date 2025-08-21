package demo.jsb2.modules.categories.domain.ports.out;

import java.util.Optional;

import demo.jsb2.modules.categories.domain.models.CategoryModel;

public interface CategoryQueryOutRepository {
    Optional<CategoryModel> findOneById(Integer id);
    Optional<CategoryModel> findOneByName(String name);
    CategoryModel save(CategoryModel category);
}
