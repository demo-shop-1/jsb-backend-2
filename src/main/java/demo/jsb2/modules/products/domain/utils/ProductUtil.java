package demo.jsb2.modules.products.domain.utils;

import demo.jsb2.modules.products.domain.ProductMessageEnum;
import demo.jsb2.modules.products.domain.exceptions.ProductQueryException;
import demo.jsb2.modules.products.domain.exceptions.ProductValidationException;

public class ProductUtil {
    public static ProductValidationException throwValidationError(ProductMessageEnum message)
            throws ProductValidationException {
        throw new ProductValidationException(message.code, message.message);
    }
    public static ProductQueryException throwQueryError(ProductMessageEnum message)
            throws ProductQueryException {
        throw new ProductQueryException(message.code, message.message);
    }
}
