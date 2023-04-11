package com.tweteroo.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String postTweet(@RequestBody @Valid TweetsDTO req) {

        String name = req.username();

        return service.create(name, new Tweets(req));
    }

    @GetMapping
    public Page<Tweets> getFiveTweetsPerPage(@RequestParam(required = false) String page) {
        return service.getFiveTweetsPerPage(page);
    }

    @GetMapping("/{username}")
    public Optional<Tweets> getAllTweetsByUser(@PathVariable String username) {
        return service.getAllTweetsByUser(username);
    }
}
