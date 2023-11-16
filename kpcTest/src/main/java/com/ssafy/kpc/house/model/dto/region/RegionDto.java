package com.ssafy.kpc.house.model.dto.region;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegionDto {
    Long cortarNo;
    Double centerLat;
    Double centerLon;
    String cortarName;
    String cortarType;

}
