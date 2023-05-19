package bookstore.admin.panel.mapper;

import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.model.dto.BookResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookResponseMapper extends EntityMapper<BookResponseDto, Book>{
    BookResponseMapper BOOK_RESPONSE_MAPPER = Mappers.getMapper(BookResponseMapper.class);
}
