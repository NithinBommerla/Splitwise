package dev.nithin.Splitwise.service;

import dev.nithin.Splitwise.exception.UserNotFoundException;
import dev.nithin.Splitwise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.nithin.Splitwise.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByID(Integer userID) {
        return userRepository.findById(userID).orElseThrow(
                () -> new UserNotFoundException("User not found with id: "+userID)
        );
    }
}
