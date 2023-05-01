package bookstore.admin.panel.mapper;


import bookstore.admin.panel.dao.entity.Publisher;

import bookstore.admin.panel.model.dto.PublisherDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface PublisherMapper {
    PublisherMapper MAPPER_2 = Mappers.getMapper(PublisherMapper.class);

    @Mapping(target = "publisherName", source = "name")
    PublisherDto toPublisherDto(Publisher publisher);

    List<PublisherDto> toPublisherDtoList(List<Publisher> publishers);

    Publisher toPublisherEntity(PublisherDto publisherDto);

    @Mapping(target = "name", source = "publisherName")
    Publisher toPublisher(PublisherDto publisherDto);
}
