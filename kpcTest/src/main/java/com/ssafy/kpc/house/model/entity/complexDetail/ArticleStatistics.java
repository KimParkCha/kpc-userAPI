package com.ssafy.kpc.house.model.entity.complexDetail;

import com.ssafy.kpc.house.model.dto.complexDetail.ComplexPyeongDetailDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArticleStatistics {

    @Id
    Integer pyeongNo;

    String dealCount; // 매매
    String leaseCount; // 전세
    String rentCount; // 월세
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
    String dealPriceString; // 매매호가
    String dealPricePerSpaceString;
    String leasePriceString; // 전세 호가
    String leasePricePerSpaceString;
    String leasePriceRateString;

    @OneToOne(mappedBy = "articleStatistics")
    ComplexPyeongDetail complexPyeongDetail;
}
