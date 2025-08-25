package demo.jsb2.modules.categories.domain.services;

import demo.jsb2.modules.categories.domain.models.CategoryModel;

public interface CategoryCommandService {
    CategoryModel createCategory(CategoryModel category);
}
