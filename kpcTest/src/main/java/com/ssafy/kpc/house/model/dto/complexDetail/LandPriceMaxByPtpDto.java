package com.ssafy.kpc.house.model.dto.complexDetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class LandPriceMaxByPtpDto {
    String ptpNo;
    String supplyArea;
    String totalArea;
    String minPrice;
    String maxPrice;
    Integer stdYear;
    String stdYmd;
    public LandPriceTaxDto landPriceTax;
}
