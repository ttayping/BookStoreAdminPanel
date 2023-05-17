package bookstore.admin.panel.mapper;


import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.entity.Publisher;
import bookstore.admin.panel.model.dto.*;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    Mapper MAPPER = Mappers.getMapper(Mapper.class);

    Book toBookEntity(List<Author> authors,
                      List<Publisher> publishers,
                      BookDto bookDto,
                      @MappingTarget Book book);

    Publisher toPublisherEntity(List<Book> books,
                                PublisherDto publisherDto,
                                @MappingTarget Publisher publisher);

    Author toAuthorEntity(List<Book> books,
                          AuthorDto authorDto,
                          @MappingTarget Author author);
}
