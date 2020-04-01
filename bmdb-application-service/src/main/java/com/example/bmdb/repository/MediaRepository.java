package com.example.bmdb.repository;


import com.example.bmdb.models.Media;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MediaRepository extends CrudRepository<Media, Long> {
    @Override
    @EntityGraph(value = "Media.detail", type = EntityGraph.EntityGraphType.LOAD)
    Iterable<Media> findAll();

    @Override
    @EntityGraph(value = "Media.detail", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Media> findById(Long aLong);
}


