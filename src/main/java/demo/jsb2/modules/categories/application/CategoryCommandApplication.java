package demo.jsb2.modules.categories.application;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import demo.jsb2.modules.categories.domain.enums.CategoryMessageEnum;
import demo.jsb2.modules.categories.domain.models.CategoryModel;
import demo.jsb2.modules.categories.domain.ports.out.CategoryQueryOutRepository;
import demo.jsb2.modules.categories.domain.services.CategoryCommandService;
import demo.jsb2.modules.categories.domain.services.CategoryQueryService;
import demo.jsb2.modules.categories.domain.utils.CategoryUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryCommandApplication extends CategoryApplication implements CategoryCommandService {

    private final CategoryQueryService categoryQueryApplication;
    private final CategoryQueryOutRepository categoryQueryOutRepository;

    @PostConstruct
    public void init() {
        nameClass = "CategoryCommandApplication";
    }

    @Override
    public CategoryModel createCategory(CategoryModel category) {
        startMethod("createCategory");

        CategoryModel categoryFound = categoryQueryApplication.findByName(category.getName());

        if (categoryFound != null) {
            infoMethod("createCategory",
                    String.format("Already exists this NAME: %s", category.getName()));
            CategoryUtil.throwValidationError(CategoryMessageEnum.NAME_REPEATED);
        }

        infoMethod("createCategory",
                String.format("Creating category with NAME: %s", category.getName()));

        // set ID to null
        category.setId(null);
        // set activation
        category.setIsActive(true);
        // set current date
        category.setDateCreated(LocalDateTime.now());

        endMethod("createCategory");
        return categoryQueryOutRepository.save(category);
    }

}
