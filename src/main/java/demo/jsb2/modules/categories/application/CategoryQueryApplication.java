package demo.jsb2.modules.categories.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.jsb2.modules.categories.domain.enums.CategoryMessageEnum;
import demo.jsb2.modules.categories.domain.models.CategoryModel;
import demo.jsb2.modules.categories.domain.ports.out.CategoryQueryOutRepository;
import demo.jsb2.modules.categories.domain.services.CategoryQueryService;
import demo.jsb2.modules.categories.domain.utils.CategoryUtil;
import demo.jsb2.utils.ObjectUtil;
import jakarta.annotation.PostConstruct;

@Service
public class CategoryQueryApplication extends CategoryApplication implements CategoryQueryService {

    @Autowired
    private final CategoryQueryOutRepository categoryQueryOutRepository = null;

    @PostConstruct
    public void init() {
        nameClass = "CategoryQueryApplication";
    }

    @Override
    public CategoryModel findById(Integer id) {
        startMethod("findById");
        if (id == null || id <= 0) {
            CategoryUtil.throwQueryError(CategoryMessageEnum.ID_INVALID);
        }
        endMethod("findById");
        return categoryQueryOutRepository.findOneById(id).orElse(null);
    }

    @Override
    public CategoryModel findByName(String name) {
        startMethod("findByName");

        if (ObjectUtil.isBlankString(name)) {
            CategoryUtil.throwQueryError(CategoryMessageEnum.NAME_BLANK);
        }

        endMethod("findByName");
        return categoryQueryOutRepository.findOneByName(name).orElse(null);
    }
}
