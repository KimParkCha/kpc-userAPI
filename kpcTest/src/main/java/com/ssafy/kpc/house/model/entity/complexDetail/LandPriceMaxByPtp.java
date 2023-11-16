package com.ssafy.kpc.house.model.entity.complexDetail;

import com.ssafy.kpc.house.model.dto.complexDetail.LandPriceTaxDto;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class LandPriceMaxByPtp { // 재산세

    @Id
    String ptpNo;

    private String supplyArea;
    private String totalArea;
    private String minPrice;
    private String maxPrice;
    private Integer stdYear;
    private String stdYmd;

    // landPriceTax
    Integer propertyTotalTax; // 재산세 합계
    Integer propertyTax;
    Integer localEduTax; // 지방 교육세
    Integer cityAreaTax; // 재산세_도시지역분
    Integer realEstateTotalTax; // 종합부동산세
    Integer decisionTax; // 결정세액
    Integer ruralSpecialTax; // 농어촌특별세

}