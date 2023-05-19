package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.entity.Review;
import bookstore.admin.panel.dao.repository.ReviewRepository;
import bookstore.admin.panel.exception.BadRequestException;
import bookstore.admin.panel.exception.Error;
import bookstore.admin.panel.exception.NotFoundException;
import bookstore.admin.panel.mapper.ReviewRequestMapper;
import bookstore.admin.panel.mapper.ReviewResponseMapper;
import bookstore.admin.panel.model.dto.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private static final ReviewRequestMapper reviewRequestMapper = ReviewRequestMapper.REVIEW_REQUEST_MAPPER;
    private static final ReviewResponseMapper reviewResponseMapper = ReviewResponseMapper.REVIEW_RESPONSE_MAPPER;

    public List<ReviewResponseDto> getAllReviews() {
        return reviewResponseMapper.toDto(reviewRepository.findAll());
    }

    public ReviewResponseDto getReviewById(Long id) {
        if (Objects.isNull(id)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Error.NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        return reviewResponseMapper.toDto(review);
    }

    public List<ReviewResponseDto> getAllReviewsByBook(String bookName) {
        List<Review> review = reviewRepository.findByBookName(bookName);
        if (review.isEmpty()){
            throw new NotFoundException(Error.NOT_FOUND_ERROR_CODE,Error.REVIEW_NOT_FOUND_ERROR_MESSAGE);
        }
            return reviewResponseMapper.toDto(review);
    }
}
