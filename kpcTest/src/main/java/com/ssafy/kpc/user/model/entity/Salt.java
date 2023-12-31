package com.ssafy.kpc.user.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Salt {

    @Id @GeneratedValue
    private int id;

    private String salt;

    public Salt(){

    }

    public Salt(String salt){
        this.salt = salt;
    }

}
