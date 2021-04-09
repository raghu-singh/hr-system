package com.hmrc.hrsystem.service;

import com.hmrc.hrsystem.dao.UserRepository;
import com.hmrc.hrsystem.exceptions.UserNotFoundException;
import com.hmrc.hrsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        Iterable<User> userIterable = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        userIterable.forEach(user -> userList.add(user));
        return userList;
    }

    public User findUser(final Long userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new UserNotFoundException("User with Id " + userId + " not found");
    }

    public User save(User user) {
        if(user == null) throw new RuntimeException("Invalid data provided.");
        return userRepository.save(user);
    }
}
