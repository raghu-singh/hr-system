package com.hmrc.hrsystem.dao;

import com.hmrc.hrsystem.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    private static List<User> users = new ArrayList<>();

    public static List<User> findAll() {
        users.add(new User(101l, "Raghu", "Singh", 44));
        users.add(new User(102l, "Adarsh", "Brar", 42));
        users.add(new User(103l, "Harry", "Singh", 42));
        users.add(new User(104l, "Bitu", "Singh", 48));
        return users;
    }
}
