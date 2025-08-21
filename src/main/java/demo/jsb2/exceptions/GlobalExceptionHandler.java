package demo.jsb2.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import demo.jsb2.utils.ObjectUtil;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalErrorDTO> handlerGenericaException(Exception exception) {

        GlobalErrorDTO globalError = new GlobalErrorDTO();
        globalError.setMessageRaw(exception.getMessage());

        if (exception.getCause() != null) {
            globalError.setMessageCode(exception.getCause().getMessage());
        }

        globalError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        globalError.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        globalError.setDate(LocalDateTime.now().format(ObjectUtil.getFormatterDefault()));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(globalError);
    }
}
