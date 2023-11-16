package com.ssafy.kpc.user.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private String response;
    private String message;

    private Object accessToken;
    private Object refreshToken;

    public Response(String response, String message, Object accessToken, Object refreshToken) {
        this.response = response;
        this.message = message;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

}
