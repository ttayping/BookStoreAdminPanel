package bookstore.admin.panel.controller;

import bookstore.admin.panel.model.dto.ReviewResponseDto;
import bookstore.admin.panel.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewResponseDto>> getAllAuthors() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ReviewResponseDto> getReviewById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @GetMapping("/book/{book}")
    public ResponseEntity<List<ReviewResponseDto>> getAllReviewsByBook(@PathVariable String book) {
        return ResponseEntity.ok(reviewService.getAllReviewsByBook(book));
    }
}
