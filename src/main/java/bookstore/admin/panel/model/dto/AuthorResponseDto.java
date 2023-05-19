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
public class AuthorResponseDto {
    private Long id;
    private String name;
    private String surName;
    private String mail;
    private String phoneNumber;
    private List<BookRequestDto> books;
}
