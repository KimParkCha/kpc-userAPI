package com.ssafy.kpc.house.model.entity.region;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="region")
public class Region {
    @Id
    private Long cortarNo; // 법정동코드
    private Double centerLat; // 위도
    private Double centerLon; // 경도
    private String cortarName; // 법정동이름
    private String cortarType; // 법정동타입
}
