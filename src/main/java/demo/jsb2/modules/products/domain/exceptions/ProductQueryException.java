package demo.jsb2.modules.products.domain.exceptions;

import demo.jsb2.exceptions.AppException;

public class ProductQueryException extends AppException {

    public ProductQueryException(String messageCode, String messageRaw) {
        super(messageCode, messageRaw);
    }

}
