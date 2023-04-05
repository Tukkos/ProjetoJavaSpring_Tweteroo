package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.DTO.TweetsDTO;
import com.tweteroo.api.model.Tweets;
import com.tweteroo.api.service.TweetsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetsController {
    
    @Autowired
    private TweetsService service;

    @PostMapping
    private String postTweet(@RequestBody @Valid TweetsDTO req) {
        return service.create(new Tweets(req));
    }

}
