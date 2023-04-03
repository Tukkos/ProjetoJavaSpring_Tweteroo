package com.tweteroo.api.DTO;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(    
    @NotBlank String username,

    @NotBlank String avatar
    ) {

}
