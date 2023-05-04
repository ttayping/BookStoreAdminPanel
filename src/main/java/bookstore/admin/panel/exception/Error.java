package bookstore.admin.panel.exception;

public interface Error {

    String NOT_FOUND_ERROR_CODE = "404";
    String BAD_REQUEST_ERROR_CODE = "400";
    String BAD_REQUEST_ERROR_MESSAGE ="Request IS WRONG";
    String BOOK_NOT_FOUND_ERROR_MESSAGE = "Book not found";
    String AUTHOR_NOT_FOUND_ERROR_MESSAGE = "Author not found";
    String PUBLISHER_NOT_FOUND_ERROR_MESSAGE = "Publisher not found";
    String REVIEW_NOT_FOUND_ERROR_MESSAGE = "Review not found";
}
