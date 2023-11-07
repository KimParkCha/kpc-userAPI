package com.ssafy.kpc.house.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "region")
public class Region {

    @Id
    private Long cortarNo;
    private double centerLat;
    private double centerLon;
    private String cortarName;
    private String cortarType;

}
