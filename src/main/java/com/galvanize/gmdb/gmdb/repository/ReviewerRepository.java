package com.galvanize.gmdb.gmdb.repository;

import com.galvanize.gmdb.gmdb.entity.Reviewer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewerRepository extends CrudRepository<Reviewer, Long> {

    // public List<Movie> findByDeliveredOn();

}