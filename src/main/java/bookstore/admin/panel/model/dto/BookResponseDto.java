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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    private Long id;
    private String name;
    private Integer stock;
    private Language language;
    private BigDecimal price;
    private Currency currency;
    private LocalDate publicationDate;
    private String description;
    private List<AuthorResponseDto> authors;
    private List <PublisherRequestDto> publishers;
}
