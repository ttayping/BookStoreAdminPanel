package bookstore.admin.panel.mapper;

import bookstore.admin.panel.dao.entity.Review;
import bookstore.admin.panel.model.dto.ReviewResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReviewResponseMapper extends EntityMapper<ReviewResponseDto, Review> {
    ReviewResponseMapper REVIEW_RESPONSE_MAPPER = Mappers.getMapper(ReviewResponseMapper.class);
}
