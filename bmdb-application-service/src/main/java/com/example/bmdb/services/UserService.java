package com.example.bmdb.services;

import com.example.bmdb.models.User;
import com.example.bmdb.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Inject
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    public void setUsers(List<User> users){
        for(User u : users){
            repository.save(u);
        }
    }

    public void saveUser(User user){
        repository.save(user);
    }

    public User findUser(String email, String password){
        return repository.findByEmailAndPassword(email, password).get(0);
    }


    public void saveAll(Iterable<User> userList) {
        repository.saveAll(userList);
    }
}
