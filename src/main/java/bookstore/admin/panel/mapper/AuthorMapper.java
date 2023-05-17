package bookstore.admin.panel.mapper;

import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.model.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper extends EntityMapper<AuthorDto, Author>{
    AuthorMapper AUTHOR_MAPPER = Mappers.getMapper(AuthorMapper.class);
}
