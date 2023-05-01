package bookstore.admin.panel.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<ApiError> handleRestException(RestException restException) {
        return ResponseEntity.status(restException.getStatus()).body(restException.getApiError());
    }

}
