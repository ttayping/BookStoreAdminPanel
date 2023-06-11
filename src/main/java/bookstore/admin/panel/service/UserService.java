package bookstore.admin.panel.service;

import bookstore.admin.panel.client.UserClient;
import bookstore.admin.panel.client.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserClient userClient;

    public List<User> getAllUsers(){
        return userClient.getAllUsers();
    }
}
