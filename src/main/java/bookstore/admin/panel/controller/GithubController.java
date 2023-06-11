package bookstore.admin.panel.controller;

import bookstore.admin.panel.client.model.Topics;
import bookstore.admin.panel.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/github")
public class GithubController {
    private final GithubService githubService;

    @GetMapping("/search/topics")
    ResponseEntity<Topics> getGithubTopics(@RequestParam String query) {
        return ResponseEntity.ok(githubService.getGithubTopics(query));
    }
}
