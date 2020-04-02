package com.example.bmdb.services.user;

import com.example.bmdb.models.User;
import com.example.bmdb.repository.UserRepository;
import com.example.bmdb.services.errors.EmailExistException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
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

    public void save(User user) throws EmailExistException {
        try{
            repository.save(user);
        }
        catch (DataIntegrityViolationException ex){
            throw new EmailExistException(ex);
        }

    }

    public User findByEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }


    public void saveAll(Iterable<User> userList) {
        repository.saveAll(userList);
    }

    public User findById(Long id) {
        return repository.findById(id).get();
    }

    public Iterable<User> findAll(){
        return repository.findAll();
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

}
