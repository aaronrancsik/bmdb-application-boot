package com.example.bmdb.repository;

import com.example.bmdb.models.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
