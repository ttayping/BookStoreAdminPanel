package bookstore.admin.panel.mapper;

import bookstore.admin.panel.dao.entity.Review;
import bookstore.admin.panel.model.dto.ReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReviewMapper extends EntityMapper<ReviewDto, Review>{
    ReviewMapper REVIEW_MAPPER = Mappers.getMapper(ReviewMapper.class);
}
