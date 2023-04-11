package com.tweteroo.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public Page<Tweets> getFiveTweetsPerPage(String query) {
        int page;

        if(query != null) {
            try {
                page = Integer.parseInt(query);
            } catch (Exception e) {
                page = 1;
            }
        } else {
            page = 1;
        }

        return repository.findAll(PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "id")));
    }
    
    public Optional<Tweets> getAllTweetsByUser(String username) {
        return repository.findByName(username);
    }
}
