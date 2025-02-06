package org.example;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Map<String, Object>> getActiveUsers() {
        return userRepository.getActiveUsers();
    }

    public Map<String, Object> getUserById(int id) {
        return userRepository.getUserById(id);
    }

}
