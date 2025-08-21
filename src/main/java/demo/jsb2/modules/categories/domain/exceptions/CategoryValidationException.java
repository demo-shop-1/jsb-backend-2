package demo.jsb2.modules.categories.domain.exceptions;

public class CategoryValidationException extends CategoryException {

    public CategoryValidationException(String messageCode, String messageRaw) {
        super(messageCode, messageRaw);
    }

}
