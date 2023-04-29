package bookstore.admin.panel.model.dto;

import bookstore.admin.panel.model.enums.Language;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BookRequestDto {
    private String name;
    private Language language;
    private List<Long> authorIdList;
}
