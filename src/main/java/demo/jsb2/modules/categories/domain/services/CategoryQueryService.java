package demo.jsb2.modules.categories.domain.services;

import demo.jsb2.modules.categories.domain.models.CategoryModel;

public interface CategoryQueryService {
    CategoryModel findById(Integer id);
    CategoryModel findByName(String name);
}
