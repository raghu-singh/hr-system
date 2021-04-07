package com.hmrc.hrsystem.init;

import com.hmrc.hrsystem.dao.UserRepository;
import com.hmrc.hrsystem.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserRepositoryInit implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryInit.class);

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        logger.info("initializing users");

        User u1 = new User("Raghu", "Singh", 40, LocalDate.of(1980, 01, 01));
        userRepository.save(u1);

        User u2 = new User("Adarshpal", "Brar", 40, LocalDate.of(1980, 01, 01));
        userRepository.save(u2);

        User u3 = new User("Harry", "Singh", 40, LocalDate.of(1980, 01, 01));
        userRepository.save(u3);

        User u4 = new User("Bittu", "Singh", 40, LocalDate.of(1980, 01, 01));
        userRepository.save(u4);
    }
}
