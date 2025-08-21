package demo.jsb2.modules.categories.domain.utils;

import demo.jsb2.modules.categories.domain.enums.CategoryMessageEnum;
import demo.jsb2.modules.categories.domain.exceptions.CategoryQueryException;
import demo.jsb2.modules.categories.domain.exceptions.CategoryValidationException;

public class CategoryUtil {

    public static CategoryQueryException throwQueryError(CategoryMessageEnum message) throws CategoryQueryException {
        throw new CategoryQueryException(message.code, message.message);
    }

    public static CategoryValidationException throwValidationError(CategoryMessageEnum message)
            throws CategoryValidationException {
        throw new CategoryValidationException(message.code, message.message);
    }

}
