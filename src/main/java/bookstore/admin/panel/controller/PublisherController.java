package bookstore.admin.panel.controller;

import bookstore.admin.panel.model.dto.BookRequestDto;
import bookstore.admin.panel.model.dto.PublisherDto;
import bookstore.admin.panel.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<Void> addPublisher(@RequestBody PublisherDto publisherDto ) {
        publisherService.addPublisher(publisherDto);
        return ResponseEntity.ok().build();
    }
}
