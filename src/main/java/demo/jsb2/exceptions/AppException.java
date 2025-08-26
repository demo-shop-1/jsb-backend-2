package demo.jsb2.exceptions;

public class AppException extends RuntimeException {
    public AppException(String messageCode, String messageRaw) {
        super(messageRaw, new RuntimeException(messageCode));
    }
}
