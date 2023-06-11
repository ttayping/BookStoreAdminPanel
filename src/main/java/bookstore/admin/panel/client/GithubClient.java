package bookstore.admin.panel.client;
import bookstore.admin.panel.client.model.Topics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Github-client", url = "${client.github.url}")
public interface GithubClient {

    @GetMapping("/search/topics")
    Topics getGithubTopics(@RequestParam(name = "q") String query);
}