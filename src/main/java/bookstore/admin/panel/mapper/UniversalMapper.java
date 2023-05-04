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


    @Mapping(target = "name", source = "authorName")
    Author toAuthorEntity(AuthorDto authorDto);

    @Mapping(target = "authorName", source = "name")
    @Mapping(target = "bookIdDtoList", source = "books")
    AuthorRequestDto toAuthorGetDto(Author authors);

    List<AuthorRequestDto> toAuthorGetDtoList(List<Author> authors);

    @Mapping(target = "name", source = "bookName")
    Book toBookEntity(BookDto bookDto);

    @Mapping(target = "bookName", source = "name")
    @Mapping(target = "authorIdList", source = "authors")
    @Mapping(target = "publisherIdList", source = "publishers")
    BookRequestDto toBookRequestDto (Book book);
    List<BookRequestDto> toBookRequestDtoList(List<Book> all);

    @Mapping(target = "name", source = "publisherName")
    Publisher toPublisherEntity(PublisherDto publisherDto);

    @Mapping(target = "publisherName", source = "name")
    @Mapping(target = "bookIdList", source = "books")
    PublisherRequestDto toPublisherRequestDto(Publisher publisher);

    List<PublisherRequestDto> toPublisherRequestDtoList (List<Publisher> publisherList);

    @Mapping(target = "reviewerName", source = "reviewer")
    @Mapping(target = "reviewNote", source = "note")
    ReviewDto toReviewDto(Review review);

    List<ReviewDto> toReviewDtoList(List<Review> all);



}
