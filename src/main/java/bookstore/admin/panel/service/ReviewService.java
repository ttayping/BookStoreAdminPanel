package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.entity.Review;
import bookstore.admin.panel.dao.repository.ReviewRepository;
import bookstore.admin.panel.exception.Error;
import bookstore.admin.panel.exception.NotFoundException;
import bookstore.admin.panel.mapper.UniversalMapper;
import bookstore.admin.panel.model.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UniversalMapper mapper = UniversalMapper.MAPPER;

    public List<ReviewDto> getAllReviews() {
        return mapper.toReviewDtoList(reviewRepository.findAll());
    }

    public ReviewDto getReviewById(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Error.BOOK_NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        return mapper.toReviewDto(review);
    }

    public List<ReviewDto> getAllReviewsByBook(String bookName) {
        return mapper.toReviewDtoList(reviewRepository.findByBookName(bookName));
    }
}
