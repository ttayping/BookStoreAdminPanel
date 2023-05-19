package bookstore.admin.panel.mapper;

import bookstore.admin.panel.dao.entity.Review;
import bookstore.admin.panel.model.dto.ReviewRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReviewRequestMapper extends EntityMapper<ReviewRequestDto, Review>{
    ReviewRequestMapper REVIEW_REQUEST_MAPPER = Mappers.getMapper(ReviewRequestMapper.class);
}
