package demo.jsb2.modules.products.domain.exceptions;

public class ProductQueryException extends ProductException {

    public ProductQueryException(String messageCode, String messageRaw) {
        super(messageCode, messageRaw);
    }

}
