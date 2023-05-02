package bookstore.admin.panel.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorGetDto {

    private String authorName;
    private List<BookGetDto> bookList;
}
