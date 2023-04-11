package com.tweteroo.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.model.Tweets;

@Repository
public interface TweetsRepository extends JpaRepository<Tweets, Long> {

    public Optional<Tweets> findByName(String name);

}
