package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public String create(User data) {
        repository.save(data);
        return "OK";
    }

    public User findUserByName(String data) {
        return repository.findByName(data);
    }
}
