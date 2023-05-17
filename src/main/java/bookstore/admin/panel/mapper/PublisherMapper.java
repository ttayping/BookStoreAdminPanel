package bookstore.admin.panel.mapper;

import bookstore.admin.panel.dao.entity.Publisher;
import bookstore.admin.panel.model.dto.PublisherDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper extends EntityMapper<PublisherDto, Publisher>{
    PublisherMapper PUBLISHER_MAPPER = Mappers.getMapper(PublisherMapper.class);
}
