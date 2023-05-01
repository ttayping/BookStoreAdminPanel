package bookstore.admin.panel.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RestException{
    public BadRequestException( String errorCode, String message) {
        super(HttpStatus.BAD_REQUEST, errorCode, message);
    }
}
