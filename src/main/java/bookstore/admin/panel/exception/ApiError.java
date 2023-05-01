package bookstore.admin.panel.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ApiError {
    private String errorCode;
    private String message;
}
