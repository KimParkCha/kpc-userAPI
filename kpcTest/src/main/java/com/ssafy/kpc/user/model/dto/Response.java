package com.ssafy.kpc.user.model.dto;

import com.ssafy.kpc.user.model.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private User user;
    private String response;
    private String message;

    private Object accessToken;
    private Object refreshToken;

    public Response(User user, String response, String message, Object accessToken, Object refreshToken) {
        this.user = user;
        this.response = response;
        this.message = message;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

}
