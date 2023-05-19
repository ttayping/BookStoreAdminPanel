package bookstore.admin.panel.mapper;

import bookstore.admin.panel.dao.entity.Publisher;
import bookstore.admin.panel.model.dto.PublisherResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherResponseMapper extends EntityMapper<PublisherResponseDto, Publisher> {
    PublisherResponseMapper PUBLISHER_RESPONSE_MAPPER = Mappers.getMapper(PublisherResponseMapper.class);
}
