package com.galvanize.gmdb.gmdb.repository;

import com.galvanize.gmdb.gmdb.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

        // public List<Movie> findByDeliveredOn();
}