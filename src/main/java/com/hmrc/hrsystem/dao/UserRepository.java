package com.hmrc.hrsystem.dao;

import com.hmrc.hrsystem.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
