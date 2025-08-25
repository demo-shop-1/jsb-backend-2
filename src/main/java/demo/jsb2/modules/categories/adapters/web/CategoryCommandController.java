package demo.jsb2.modules.categories.adapters.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.jsb2.modules.categories.adapters.dto.CategoryCreateRequestDTO;
import demo.jsb2.modules.categories.adapters.dto.CategoryCreateResponseDTO;
import demo.jsb2.modules.categories.adapters.mappers.CategoryMapper;
import demo.jsb2.modules.categories.domain.models.CategoryModel;
import demo.jsb2.modules.categories.domain.services.CategoryCommandService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryCommandController extends CategoryController {
    private final CategoryCommandService categoryCommandApplication;

    @PostConstruct
    public void init() {
        nameClass = "CategoryCommandController";
    }

    @PostMapping("/category/save")
    public ResponseEntity<CategoryCreateResponseDTO> createCategory(@RequestBody CategoryCreateRequestDTO request) {
        startMethod("createCategory");

        CategoryModel categoryToCreate = CategoryMapper.toCategoryModel(request);
        CategoryModel categoryCreated = categoryCommandApplication.createCategory(categoryToCreate);

        endMethod("createCategory");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CategoryMapper.toCategoryCreateResponseDTO(categoryCreated));
    }

}
