package ru.yandex.practicum.catsgram.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.Collection;

@Slf4j
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public Collection<User> findAll() {
        return userService.findAll();
    }

    @PostMapping(value = "/users")
    public User create(@RequestBody User user) throws InvalidEmailException {
        return userService.create(user);
    }

    @PutMapping("/users")
    public User update(@RequestBody User user) throws InvalidEmailException {
        return userService.update(user);
    }

    @GetMapping("/users/{userEmail}")
    public User findUserByEmail(@PathVariable("userEmail") String email) {
        return userService.findUserByEmail(email);
    }
}

