package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByName(String name);

}
