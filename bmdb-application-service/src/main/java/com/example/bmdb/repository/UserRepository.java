package com.example.bmdb.repository;


import com.example.bmdb.models.User;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
    List<User> findByEmailAndPassword(String email, String password);
}
