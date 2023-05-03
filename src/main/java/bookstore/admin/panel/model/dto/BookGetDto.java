package bookstore.admin.panel.model.dto;

import bookstore.admin.panel.model.enums.Currency;
import bookstore.admin.panel.model.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookGetDto {
    private String bookGetName;
    private Integer stock;
    private Language language;
    private Currency currency;
    private BigDecimal price;
    private String description;
}
