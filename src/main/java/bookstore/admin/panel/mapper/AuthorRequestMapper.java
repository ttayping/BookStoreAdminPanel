package bookstore.admin.panel.mapper;

import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.model.dto.AuthorRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorRequestMapper extends EntityMapper<AuthorRequestDto, Author>{
    AuthorRequestMapper AUTHOR_REQUEST_MAPPER = Mappers.getMapper(AuthorRequestMapper.class);
}
