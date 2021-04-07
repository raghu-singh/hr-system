package com.hmrc.hrsystem.dao;

import com.hmrc.hrsystem.model.User;
import com.hmrc.hrsystem.property.Gender;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    private static List<User> users = new ArrayList<>();

    public static List<User> findAll() {
        users.add(new User(101l, "Raghu", "Singh", 44, new BigDecimal(50000), Gender.Male));
        users.add(new User(102l, "Adarsh", "Brar", 42, new BigDecimal(55000), Gender.Male));
        users.add(new User(103l, "Harry", "Singh", 42, new BigDecimal(65000), Gender.Male));
        users.add(new User(104l, "Bitu", "Singh", 48, new BigDecimal(75000), Gender.Male));
        return users;
    }
}
