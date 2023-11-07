package com.ssafy.kpc.house.model.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegionDto {

    private Long cortarNo;
    private double centerLat;
    private double centerLon;
    private String cortarName;
    private String cortarType;
}
