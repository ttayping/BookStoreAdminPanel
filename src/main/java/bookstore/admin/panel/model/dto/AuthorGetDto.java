package bookstore.admin.panel.model.dto;

import bookstore.admin.panel.dao.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorGetDto {

    private String authorName;
    private List<Book> bookList;
}
