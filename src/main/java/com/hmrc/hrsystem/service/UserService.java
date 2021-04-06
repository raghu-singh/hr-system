package com.hmrc.hrsystem.service;

import com.hmrc.hrsystem.dao.UserDAO;
import com.hmrc.hrsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    public List<User> findAllUsers() {
        return UserDAO.findAll();
    }

    public Collection<User> findUser(Long id) {
        List<User> users = UserDAO.findAll();
        List<User> list = users.stream().filter(usr -> usr.getId() == id).collect(Collectors.toList());
        if(list.isEmpty()) throw new RuntimeException("Invalid User.No user found for id:"+id);
        return list;
    }
}
