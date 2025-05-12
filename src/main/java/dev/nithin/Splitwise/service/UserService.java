package dev.nithin.Splitwise.service;

import dev.nithin.Splitwise.exception.UserNotFoundException;
import dev.nithin.Splitwise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.nithin.Splitwise.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByID(Integer userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("User not found with id: "+userId)
        );
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
