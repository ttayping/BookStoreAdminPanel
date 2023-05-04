package bookstore.admin.panel.controller;


import bookstore.admin.panel.model.dto.PublisherDto;
import bookstore.admin.panel.model.dto.PublisherRequestDto;
import bookstore.admin.panel.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<Void> addPublisher(@RequestBody PublisherDto publisherDto) {
        publisherService.addPublisher(publisherDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePublisher(@PathVariable Long id,
                                                @RequestBody PublisherDto publisherDto) {
        publisherService.updatePublisher(id, publisherDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisherById(@PathVariable Long id) {
        publisherService.deletePublisherById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherRequestDto> getPublisherById(@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.getPublisherById(id));
    }

    @GetMapping
    public ResponseEntity<List<PublisherRequestDto>> getPublishers() {
        return ResponseEntity.ok(publisherService.getAllPublishers());
    }
}
