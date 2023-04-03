package com.tweteroo.api.model;

import com.tweteroo.api.DTO.TweetsDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Tweets {
    
    public Tweets(TweetsDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
        this.text = data.text();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 50, nullable = false)
    private String avatar;

    @Column(length = 500, nullable = false)
    private String text;
}
