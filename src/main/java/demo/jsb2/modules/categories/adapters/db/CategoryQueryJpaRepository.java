package demo.jsb2.modules.categories.adapters.db;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demo.jsb2.modules.categories.adapters.entities.CategoryEntity;
import demo.jsb2.modules.categories.adapters.mappers.CategoryMapper;
import demo.jsb2.modules.categories.domain.models.CategoryModel;
import demo.jsb2.modules.categories.domain.ports.out.CategoryQueryOutRepository;

@Repository
public interface CategoryQueryJpaRepository extends JpaRepository<CategoryEntity, Integer>, CategoryQueryOutRepository {

    @Override
    default Optional<CategoryModel> findOneById(Integer id) {
        return findById(id).map(CategoryMapper::toCategoryModel);
    }

    @Override
    default Optional<CategoryModel> findOneByName(String name) {
        return queryFindOneByName(name).map(CategoryMapper::toCategoryModel);
    }

    @Query("SELECT c FROM CategoryEntity c WHERE LOWER(c.name) LIKE LOWER(:name)")
    Optional<CategoryEntity> queryFindOneByName(String name);

    @Override
    default CategoryModel save(CategoryModel category) {
        return CategoryMapper.toCategoryModel(save(CategoryMapper.toCategoryEntity(category)));
    }

    @Override
    default List<CategoryModel> findAllCategories() {
        return findAll().stream().map(CategoryMapper::toCategoryModel).toList();
    }

}
