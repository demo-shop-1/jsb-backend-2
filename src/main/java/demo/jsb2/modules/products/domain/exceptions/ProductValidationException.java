package demo.jsb2.modules.products.domain.exceptions;

import demo.jsb2.exceptions.AppException;

public class ProductValidationException extends AppException {

    public ProductValidationException(String messageCode, String messageRaw) {
        super(messageCode, messageRaw);
    }

}
