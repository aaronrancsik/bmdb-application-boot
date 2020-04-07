package com.example.bmdb.repository;

import com.example.bmdb.models.Actor;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ActorRepository extends CrudRepository<Actor, Long> {

    @Override
    @EntityGraph(value = "sel", type = EntityGraph.EntityGraphType.FETCH)
    @Query(
            value = "SELECT a FROM Actor a INNER JOIN FETCH a.filmography WHERE a.id = :id",
            countQuery = "SELECT COUNT(a) FROM Actor a INNER JOIN a.filmography WHERE a.id = :id"
    )
    Optional<Actor> findById(@Param("id") Long id);
}
