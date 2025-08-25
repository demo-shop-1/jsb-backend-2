package demo.jsb2.modules.categories.adapters.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.jsb2.modules.categories.adapters.dto.CategoryGetOneResponseDTO;
import demo.jsb2.modules.categories.adapters.mappers.CategoryMapper;
import demo.jsb2.modules.categories.domain.enums.CategoryMessageEnum;
import demo.jsb2.modules.categories.domain.models.CategoryModel;
import demo.jsb2.modules.categories.domain.services.CategoryQueryService;
import demo.jsb2.modules.categories.domain.utils.CategoryUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryQueryController extends CategoryController {

    @Autowired
    private final CategoryQueryService categoryQueryApplication;

    @PostConstruct
    public void init() {
        nameClass = "CategoryQueryController";
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryGetOneResponseDTO> getOneCategory(@PathVariable Integer id) {
        startMethod("getOneCategory");

        CategoryModel categoryFound = categoryQueryApplication.findById(id);

        if (categoryFound == null) {
            CategoryUtil.throwQueryError(CategoryMessageEnum.CATEGORY_NOT_EXIST);
        }

        endMethod("getOneCategory");
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(CategoryMapper.toCategoryGetOneResponseDTO(categoryFound));
    }

}
