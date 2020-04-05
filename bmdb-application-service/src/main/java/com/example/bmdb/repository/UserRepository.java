package com.example.bmdb.repository;


import com.example.bmdb.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String name);

    @Transactional
    @Modifying
    @Query("update User u set u.email = ?1, u.name = ?2 where u.id = ?3")
    void setUserInfoById(String email, String name, long id);
}
