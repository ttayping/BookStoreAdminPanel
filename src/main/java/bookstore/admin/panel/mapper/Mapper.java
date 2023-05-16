package bookstore.admin.panel.mapper;


import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.entity.Publisher;
import bookstore.admin.panel.dao.entity.Review;
import bookstore.admin.panel.model.dto.*;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    Mapper MAPPER = Mappers.getMapper(Mapper.class);


    @Mapping(target = "name", source = "authorName")
    Author toAuthorEntity(AuthorDto authorDto);

    @Mapping(target = "authorName", source = "name")
    @Mapping(target = "bookIdDtoList", source = "books")
    AuthorResponseDto toAuthorRequestDto(Author authors);

    List<AuthorResponseDto> toAuthorRequestDtoList(List<Author> authors);

    @Mapping(target = "name", source = "bookName")
    Book toBookEntity(BookDto bookDto);

    Book toBookEntity(List<Author> authors,
                      List<Publisher> publishers,
                      BookDto bookDto,
                      @MappingTarget Book book);

    @Mapping(target = "bookName", source = "name")
    @Mapping(target = "authorIdList", source = "authors")
    @Mapping(target = "publisherIdList", source = "publishers")
    BookResponseDto toBookRequestDto(Book book);

    List<BookResponseDto> toBookRequestDtoList(List<Book> all);

    @Mapping(target = "name", source = "publisherName")
    Publisher toPublisherEntity(PublisherDto publisherDto);

    @Mapping(target = "publisherName", source = "name")
    @Mapping(target = "bookIdList", source = "books")
    PublisherResponseDto toPublisherRequestDto(Publisher publisher);

    List<PublisherResponseDto> toPublisherRequestDtoList(List<Publisher> publisherList);

    @Mapping(target = "reviewerName", source = "reviewer")
    @Mapping(target = "reviewNote", source = "note")
    ReviewDto toReviewDto(Review review);

    List<ReviewDto> toReviewDtoList(List<Review> all);

}
