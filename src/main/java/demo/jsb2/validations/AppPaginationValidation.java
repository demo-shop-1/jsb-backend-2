package demo.jsb2.validations;

import org.springframework.stereotype.Service;

import demo.jsb2.enums.AppIntegerEnum;
import demo.jsb2.enums.AppPaginationEnum;
import demo.jsb2.exceptions.AppPaginationException;
import demo.jsb2.utils.AppObjectUtil;
import demo.jsb2.utils.AppThrowUtil;

@Service
public class AppPaginationValidation {

    public Boolean validatePageFull(String page) throws AppPaginationException {
        Boolean isValid = true;

        if (AppObjectUtil.isNull(page)) {
            throw AppThrowUtil.throwPaginationException(AppPaginationEnum.PAGE_EMPTY);
        } else if (Integer.parseInt(page) < AppIntegerEnum.PAGE_SIZE_MIN.value ||
                Integer.parseInt(page) > AppIntegerEnum.PAGE_SIZE_MAX.value) {
            throw AppThrowUtil.throwPaginationException(AppPaginationEnum.PAGE_INVALID);
        }

        return isValid;
    }

    public Boolean validateSizeFull(String size) throws AppPaginationException {
        Boolean isValid = true;
        if (AppObjectUtil.isNull(size)) {
            throw AppThrowUtil.throwPaginationException(AppPaginationEnum.SIZE_EMPTY);
        } else if (Integer.parseInt(size) < AppIntegerEnum.SIZE_MIN.value ||
                Integer.parseInt(size) > AppIntegerEnum.SIZE_MAX.value) {
            throw AppThrowUtil.throwPaginationException(AppPaginationEnum.SIZE_INVALID);
        }
        return isValid;
    }

    public Boolean validateCategory(String category) throws AppPaginationException {
        Boolean isValid = true;
        if (!AppObjectUtil.isNull(category) && Integer.parseInt(category) < AppIntegerEnum.CATEGORY_MIN.value) {
            throw AppThrowUtil.throwPaginationException(AppPaginationEnum.CATEGORY_INVALID);
        }
        return isValid;
    }
}
