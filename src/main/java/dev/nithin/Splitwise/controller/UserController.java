package dev.nithin.Splitwise.controller;

import dev.nithin.Splitwise.DTO.UserResponseDTO;
import dev.nithin.Splitwise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import dev.nithin.Splitwise.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody User user) {
        user = userService.save(user);
        // return ResponseEntity.ok(user);
        return new ResponseEntity<>(UserResponseDTO.from(user), HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable("userId") int userId) {
        User user = userService.findByID(userId);
        // return ResponseEntity.ok(user);
        return ResponseEntity.ok(UserResponseDTO.from(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = userService.findAll();
        // return ResponseEntity.ok(users);
        List<UserResponseDTO> userResponseDTOs = convertUsersToResponseDTO(users);
        return ResponseEntity.ok(userResponseDTOs);
    }

    private List<UserResponseDTO> convertUsersToResponseDTO(List<User> users) {
        // List<UserResponseDTO> userResponseDTOS = users.stream().map(UserResponseDTO::from).toList();
        List<UserResponseDTO> userResponseDTOs = new ArrayList<>();
        for (User user : users) {
            userResponseDTOs.add(UserResponseDTO.from(user));
        }
        return userResponseDTOs;
    }
}
