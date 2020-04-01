package com.example.bmdb.services;

import com.example.bmdb.models.Actor;

import com.example.bmdb.repository.ActorRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private ActorRepository repository;

    @Inject
    public void setRepository(ActorRepository repository) {
        this.repository = repository;
    }

    public void save(Actor actor){
        repository.save(actor);
    }

    public void saveAll(Iterable<Actor> actors){
        if(actors!=null){
            repository.saveAll(actors);
        }
    }

    public Actor findById(long id){
        return repository.findById(id).get();
    }

    public Iterable<Actor> findAll(){
        return repository.findAll();
    }
}
