package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.DTO.TweetsDTO;
import com.tweteroo.api.model.Tweets;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.TweetsRepository;

@Service
public class TweetsService {

    @Autowired
    private TweetsRepository repository;

    @Autowired
    private UserService userService;

    public String create(String name, Tweets data) {
        User user = userService.findUserByName(name);

        TweetsDTO newTweet = new TweetsDTO(user.getUsername(), user.getAvatar(), data.getText());

        repository.save(new Tweets(newTweet));
        return "OK";
    }
    
}
