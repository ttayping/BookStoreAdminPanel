package bookstore.admin.panel.model.dto;

import bookstore.admin.panel.model.enums.Currency;
import bookstore.admin.panel.model.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String bookName;
    private Language language;
    private BigDecimal price;
    private Currency currency;
    private LocalDate publicationDate;
    private String description;
    private List<Long> authorIdList;
}
