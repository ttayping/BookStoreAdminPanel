package bookstore.admin.panel.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestException extends RuntimeException {

    private final HttpStatus status;
    private final ApiError apiError;

    public RestException(HttpStatus status, ApiError apiError) {
        this.status = status;
        this.apiError = apiError;
    }

    public RestException(HttpStatus status, String errorCode, String message) {
        this(status, new ApiError(errorCode, message));
    }

}
