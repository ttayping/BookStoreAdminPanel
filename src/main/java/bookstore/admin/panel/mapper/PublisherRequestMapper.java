package bookstore.admin.panel.mapper;

import bookstore.admin.panel.dao.entity.Publisher;
import bookstore.admin.panel.model.dto.PublisherRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherRequestMapper extends EntityMapper<PublisherRequestDto, Publisher>{
    PublisherRequestMapper PUBLISHER_REQUEST_MAPPER = Mappers.getMapper(PublisherRequestMapper.class);
}
