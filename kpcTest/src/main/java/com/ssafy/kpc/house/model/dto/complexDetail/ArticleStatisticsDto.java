package com.ssafy.kpc.house.model.dto.complexDetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleStatisticsDto {
    Integer pyeongNo;
    String dealCount;
    String leaseCount;
    String rentCount;
    String shortTermRentCount;
    String dealPriceMin;
    String dealPriceMax;
    String leasePriceMin;
    String leasePriceMax;
    String dealPricePerSpaceMin;
    String dealPricePerSpaceMax;
    String leasePricePerSpaceMin;
    String leasePricePerSpaceMax;
    String leasePriceRateMin;
    String leasePriceRateMax;
    String dealPriceString;
    String dealPricePerSpaceString;
    String leasePriceString;
    String leasePricePerSpaceString;
    String leasePriceRateString;
}