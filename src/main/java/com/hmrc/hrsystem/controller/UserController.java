package com.hmrc.hrsystem.controller;

import com.hmrc.hrsystem.exceptions.UserNotFoundException;
import com.hmrc.hrsystem.model.User;
import com.hmrc.hrsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> listUsers = userService.findAllUsers();
        return new ResponseEntity<>(listUsers, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable final Long userId) throws UserNotFoundException {
        User user = userService.findUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody User user2){
        User user1 = userService.save(user2);
        return new ResponseEntity<User>(user1,HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public  ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
