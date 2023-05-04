package bookstore.admin.panel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {

    private Long id;
    private String authorName;
    private String surname;
    private String mail;
    private String phoneNumber;
    private List<BookIdDto> bookIdDtoList;
}
