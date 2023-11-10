package com.ssafy.kpc.user.model.dto;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String password;
    private String email;

    public UserDto(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
