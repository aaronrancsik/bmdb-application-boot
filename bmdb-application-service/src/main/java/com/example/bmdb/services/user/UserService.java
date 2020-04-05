package com.example.bmdb.services.user;

import com.example.bmdb.models.User;
import com.example.bmdb.repository.UserRepository;
import com.example.bmdb.services.errors.EmailExistException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.net.ConnectException;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {


    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Inject
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


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
        passToHash(Arrays.asList(user));
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
        passToHash(userList);
        repository.saveAll(userList);
    }

    private void passToHash(Iterable<User> userList) {
        for(var u: userList){
            u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        }
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
