package com.example.bmdb.services;

import com.example.bmdb.models.Review;
import com.example.bmdb.repository.ReviewRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;
    @Inject
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void save(Review review){
        reviewRepository.save(review);
    }

    public void saveAll(Iterable<Review> reviews){
        reviewRepository.saveAll(reviews);
    }

    public Optional<Review> findById(Long id){
        return reviewRepository.findById(id);
    }

//    public boolean existsById(Long aLong){
//
//    }


    public Iterable<Review> findAll(){
        return reviewRepository.findAll();
    }

//    public Iterable<Review> findAllById(Iterable<Long> iterable){
//
//    }
//
//    public long count(){
//
//    }
//
//    public void deleteById(Long aLong){
//
//    }
//
//    public void delete(Review review){
//
//    }
//
//
//    public void deleteAll(Iterable<Review> iterable){
//
//    }
//
//
//    public void deleteAll(){
//
//    }
}
