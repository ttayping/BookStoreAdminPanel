package bookstore.admin.panel.model.dto;

import bookstore.admin.panel.model.enums.Currency;
import bookstore.admin.panel.model.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookGetDto {
    private String bookName;
    private Language language;
    private BigDecimal price;
    private Currency currency;
    private LocalDate publicationDate;
    private String description;
}
