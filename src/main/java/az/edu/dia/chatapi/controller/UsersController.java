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

@CrossOrigin()
@RestController
@RequestMapping(path = "/api/users")
public class UsersController {

    private static final String profileServiceUrl = "https://api.dicebear.com/7.x/adventurer/png?seed=";

    private List<User> allUsers = new ArrayList<>();

    @GetMapping("/me") // => /api/users/me
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("") // => /api/users
    public List<User> getAllUsers() {
        return allUsers;
    }

    @PostMapping("/{name}") // => /api/users/username
    public User createNewUser(@PathVariable() String name) throws Exception {

        // check if username exists
        for (User usr : allUsers) {
            if (usr.getUsername().equals(name)) {
                throw new Exception("username already taken");
            }
        }

        User aUser = new User(name, profileServiceUrl + name);
        allUsers.add(aUser);
        return aUser;
    }

}
