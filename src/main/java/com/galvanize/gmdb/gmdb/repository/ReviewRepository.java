package com.galvanize.gmdb.gmdb.repository;

import com.galvanize.gmdb.gmdb.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    // public List<Movie> findByDeliveredOn();

}
