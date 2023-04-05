package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.model.Tweets;

@Repository
public interface TweetsRepository extends JpaRepository<Tweets, Long> {
    
}
