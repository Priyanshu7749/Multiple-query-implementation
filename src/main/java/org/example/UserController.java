package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/active")
    public List<Map<String, Object>> getActiveUsers() {
        return userService.getActiveUsers();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

}
