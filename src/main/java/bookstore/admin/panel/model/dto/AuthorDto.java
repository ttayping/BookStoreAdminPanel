package bookstore.admin.panel.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorDto {
    private String name;
}