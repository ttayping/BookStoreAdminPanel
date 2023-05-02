package bookstore.admin.panel.mapper;


import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.entity.Publisher;
import bookstore.admin.panel.dao.entity.Review;
import bookstore.admin.panel.model.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UniversalMapper {
    UniversalMapper MAPPER = Mappers.getMapper(UniversalMapper.class);

    @Mapping(target = "bookName", source = "name")
    BookDto toBookDto(Book book);

    List<BookDto> toBookDtoList(List<Book> books);

    @Mapping(target = "name", source = "bookName")
    Book toBookEntity (BookDto bookDto);

    @Mapping(target = "publisherName", source = "name")
    PublisherDto toPublisherDto(Publisher publisher);

    List<PublisherDto> toPublisherDtoList(List<Publisher> publishers);
    @Mapping(target = "name", source = "publisherName")
    Publisher toPublisherEntity(PublisherDto publisherDto);
    List <Publisher> toPublisherList (List<Publisher> publishers);


    @Mapping(target = "authorName", source = "name")
    AuthorDto toAuthorDto(Author author);
    List<AuthorDto> toAuthorDtoList(List<Author> all);

    @Mapping(target = "name", source = "authorName")
    Author toAuthorEntity(AuthorDto authorDto);

    List<Author> toAuthorList(List<AuthorDto> all);

    @Mapping(target = "authorName", source = "name")
    @Mapping(target = "bookList", source = "books")
    AuthorGetDto toAuthorGetDto (Author author);
    List<AuthorGetDto> toAuthorGetDtoList (List<Author> authors);
    @Mapping(target = "reviewerName", source = "reviewer")
    @Mapping(target = "reviewNote", source = "note")
    List<ReviewDto> toReviewDtoList(List<Review> all);

    ReviewDto toReviewDto(Review review);
}
