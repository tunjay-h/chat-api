package az.edu.dia.chatapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.edu.dia.chatapi.model.User;
import az.edu.dia.chatapi.service.UserService;

@CrossOrigin()
@RestController
@RequestMapping(path = "/api/users")
public class UsersController {

    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("") // => /api/users
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/{name}") // => /api/users/username
    public User createNewUser(@PathVariable() String name) throws Exception {

        User newUser = userService.saveUser(name);
        return newUser;
    }

}
