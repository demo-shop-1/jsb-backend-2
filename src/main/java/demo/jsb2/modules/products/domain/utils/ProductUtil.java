package demo.jsb2.modules.products.domain.utils;

import demo.jsb2.modules.products.domain.enums.ProductMessageEnum;
import demo.jsb2.modules.products.domain.exceptions.ProductQueryException;
import demo.jsb2.modules.products.domain.exceptions.ProductValidationException;

public class ProductUtil {
    public static ProductValidationException throwValidationError(ProductMessageEnum message) {
        return new ProductValidationException(message.code, message.message);
    }

    public static ProductQueryException throwQueryError(ProductMessageEnum message) {
        return new ProductQueryException(message.code, message.message);
    }
}
