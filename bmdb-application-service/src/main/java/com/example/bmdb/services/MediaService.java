package com.example.bmdb.services;

import com.example.bmdb.models.Media;
import com.example.bmdb.models.Review;
import com.example.bmdb.models.User;
import com.example.bmdb.repository.MediaRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

@Service
public class MediaService {

    private MediaRepository repository;

    @Inject
    public void setRepository(MediaRepository repository) {
        this.repository = repository;
    }

    public void save(Media media){
        if(media!=null){
            repository.save(media);
        }
    }

    public void saveAll(List<Media> medias){
        repository.saveAll(medias);
    }

    public Media findById(long id){
        return repository.findById(id).get();
    }

    public Iterable<Media> findAll(){
        return repository.findAll();
    }

    public double getAverageRating(long mediaId){
        double sum = repository.findById(mediaId).get().getReviews().stream().mapToInt(r->r.getRating().rate).sum();
        double num = repository.findById(mediaId).get().getReviews().stream().count();
        return sum/num;
    }

}
