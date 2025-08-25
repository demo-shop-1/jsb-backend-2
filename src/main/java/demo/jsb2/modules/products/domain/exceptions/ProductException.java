package demo.jsb2.modules.products.domain.exceptions;

public class ProductException extends RuntimeException {
    public ProductException(String messageCode, String messageRaw) {
        super(messageRaw, new RuntimeException(messageCode));
    }
}
