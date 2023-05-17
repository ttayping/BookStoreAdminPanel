package bookstore.admin.panel.mapper;

import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.model.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper extends EntityMapper<BookDto, Book>{
    BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);
}
