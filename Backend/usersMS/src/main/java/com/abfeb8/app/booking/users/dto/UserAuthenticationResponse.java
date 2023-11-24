package com.abfeb8.app.booking.users.dto;

import lombok.Builder;

@Builder
public record UserAuthenticationResponse(
        String authToken,
        Long userId
) {}
