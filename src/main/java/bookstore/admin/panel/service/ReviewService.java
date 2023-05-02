package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.entity.Review;
import bookstore.admin.panel.dao.repository.BookRepository;
import bookstore.admin.panel.dao.repository.ReviewRepository;
import bookstore.admin.panel.exception.NotFoundException;
import bookstore.admin.panel.mapper.UniversalMapper;
import bookstore.admin.panel.model.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;
    private final UniversalMapper mapper=UniversalMapper.MAPPER;


    public List<ReviewDto> getAllReviews() {
        return mapper.toReviewDtoList(reviewRepository.findAll());
    }
    public ReviewDto getReviewById (Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(()->
                new NotFoundException("code 404","Review didnt found. Please change parameters"));
        return mapper.toReviewDto(review);
    }
    public List<ReviewDto> getAllReviewsByBook(String bookName) {
//        Book book = bookRepository.findBookByName(bookName);
        return mapper.toReviewDtoList(reviewRepository.findByBookName(bookName));
    }
}
