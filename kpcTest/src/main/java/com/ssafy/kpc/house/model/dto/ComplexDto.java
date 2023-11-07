package com.ssafy.kpc.house.model.dto;

import lombok.*;
import org.springframework.context.annotation.Scope;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComplexDto {

    private int complexNo;
    private String complexName;
    private Long cortarNo;

    private String realEstateTypeCode;
    private String realEstateTypeName;

    private double latitude;
    private double longitude;

    private int highFloor;
    private int lowFloor;
    private int useApproveYmd;

    private int totalBuildingCount;
    private int dealCount;
    private int leaseCount;
    private int rentCount;
    private int shortTermRentCount;
    private int cortarAddress;
}
