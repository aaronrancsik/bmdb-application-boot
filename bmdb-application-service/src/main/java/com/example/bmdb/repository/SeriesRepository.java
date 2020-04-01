package com.example.bmdb.repository;


import com.example.bmdb.models.Series;
import org.springframework.data.repository.CrudRepository;

public interface SeriesRepository extends CrudRepository<Series, Long> {
}
