package bookstore.admin.panel.client;

import bookstore.admin.panel.client.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "User-client", url = "${client.user.url}")
public interface UserClient {
    @GetMapping("/user")
    List<User> getAllUsers();
}
