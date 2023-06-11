package bookstore.admin.panel.service;

import bookstore.admin.panel.client.GithubClient;
import bookstore.admin.panel.client.model.Topics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GithubService {
    private final GithubClient githubClient;

    public Topics getGithubTopics(String query){
        return githubClient.getGithubTopics(query);
    }
}
