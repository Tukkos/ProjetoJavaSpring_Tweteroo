package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.model.Tweets;
import com.tweteroo.api.repository.TweetsRepository;

@Service
public class TweetsService {

    @Autowired
    private TweetsRepository repository;

    public String create(Tweets data) {
        repository.save(data);
        return "OK";
    }
    
}
