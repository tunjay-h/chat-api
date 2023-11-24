package az.edu.dia.chatapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import az.edu.dia.chatapi.model.User;
import az.edu.dia.chatapi.repo.UserRepo;

@Service
public class UserService {

    private static final String profileServiceUrl = "https://api.dicebear.com/7.x/adventurer/png?seed=";
    
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public User saveUser(String name) throws Exception {
        // check if username exists
        for (User usr : getAllUsers()) {
            if (usr.getUsername().equals(name)) {
                throw new Exception("username already taken");
            }
        }

        User aUser = new User(name, profileServiceUrl + name);

        return userRepo.createUser(aUser);
    }
}
