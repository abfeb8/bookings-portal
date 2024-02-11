package com.abfeb8.app.booking.users.dto;

import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String authToken,
        String username
) {}
