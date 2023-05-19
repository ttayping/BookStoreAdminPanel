package bookstore.admin.panel.mapper;

import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.model.dto.AuthorResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorResponseMapper extends EntityMapper<AuthorResponseDto, Author>{
    AuthorResponseMapper AUTHOR_RESPONSE_MAPPER = Mappers.getMapper(AuthorResponseMapper.class);
}
