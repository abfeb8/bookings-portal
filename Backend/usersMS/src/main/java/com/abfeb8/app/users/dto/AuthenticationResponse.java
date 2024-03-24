package com.abfeb8.app.users.dto;

import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String authToken,
        String username
) {
}
