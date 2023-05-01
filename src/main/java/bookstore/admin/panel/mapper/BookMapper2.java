package bookstore.admin.panel.mapper;


import bookstore.admin.panel.dao.entity.Book;

import bookstore.admin.panel.model.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper2 {
    BookMapper2 MAPPER_2 = Mappers.getMapper(BookMapper2.class);
    @Mapping(target = "bookName", source = "name")
    BookDto toBookDto(Book book);

    List<BookDto> toBookDtoList(List<Book> books);


}
