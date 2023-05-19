package bookstore.admin.panel.mapper;

import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.model.dto.BookRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookRequestMapper extends EntityMapper<BookRequestDto, Book>{
    BookRequestMapper BOOK_REQUEST_MAPPER = Mappers.getMapper(BookRequestMapper.class);
}
