package com.tweteroo.api.DTO;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(
    
    @NotBlank String username,

    @NotBlank @URL String avatar

    ) {

}
