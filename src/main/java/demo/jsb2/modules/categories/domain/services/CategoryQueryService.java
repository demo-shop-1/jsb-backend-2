package demo.jsb2.modules.categories.domain.services;

import java.util.List;

import demo.jsb2.modules.categories.domain.models.CategoryModel;

public interface CategoryQueryService {
    CategoryModel findById(Integer id);

    CategoryModel findByName(String name);

    Boolean existThisCategory(Integer id);

    List<CategoryModel> findAll();
}
