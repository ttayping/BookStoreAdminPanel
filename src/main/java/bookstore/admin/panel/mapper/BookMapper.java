package bookstore.admin.panel.mapper;

import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.model.dto.AuthorDto;
import bookstore.admin.panel.model.dto.BookDto;
import bookstore.admin.panel.model.dto.BookRequestDto;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {
    private BookMapper() {
    }

    public static AuthorDto toAuthorDto(Author author) {
        return AuthorDto.builder().name(author.getName()).build();
    }

    public static Book toBook(BookRequestDto bookRequestDto) {
        return Book.builder()
                .name(bookRequestDto.getName())
                .language(bookRequestDto.getLanguage())

                .build();
    }

    public static BookDto toBookDto(Book book) {
        return BookDto.builder().
                authorDtoList(toAuthorDtoList(book.getAuthors()))
                .bookName(book.getName()).build();
    }

    public static List<BookDto> toBookDtoList(List<Book> books) {
        return books.stream().map(BookMapper::toBookDto).collect(Collectors.toList());
    }

    public static List<AuthorDto> toAuthorDtoList(List<Author> authors) {
        return authors.stream().map(BookMapper::toAuthorDto).collect(Collectors.toList());
    }
}
