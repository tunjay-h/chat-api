package az.edu.dia.chatapi.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import az.edu.dia.chatapi.model.User;

@Repository
public class UserRepo {
    private static final List<User> allUsers = new ArrayList<>();
    private static long generatedID = 1; // increment on new user

    public List<User> getAllUsers() {
        return allUsers;
    }

    public User createUser(User user) {
        generatedID += 1;
        user.setID(generatedID);
        allUsers.add(user);
        return user;
    }
}
