package com.ssafy.kpc.house.model.entity.complexDetail;

import com.ssafy.kpc.house.model.entity.complex.Complex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="complexDetail")
public class ComplexDetail { // 아파트 상세 정보
    @Id
    private Long complexNo; // 아파트번호

    private String complexName; // 아파트명
    private Long cortarNo; // 법정동코드
    private String realEstateTypeCode; //
    private String realEstateTypeName;
    private String detailAddress; // 법정동 주소
    private String roadAddress; //도로명 주소
    private Double latitude; // 위도
    private Double longitude; // 경도
    private Integer totalHouseholdCount; // 세대수
    private Integer totalLeaseHouseholdCount; // 임대세대수
    private Integer permanentLeaseHouseholdCount;
    private Integer nationLeaseHouseholdCount;
    private Integer civilLeaseHouseholdCount;
    private Integer publicLeaseHouseholdCount;
    private Integer longTermLeaseHouseholdCount;
    private Integer etcLeaseHouseholdCount;
    private Integer highFloor;
    private Integer lowFloor;
    private String useApprovueYmd;
    private Integer totalDongCount;
    private Float maxSupplyArea;
    private Float minSupplyArea;
    private Integer dealCount;
    private Integer rentCount;
    private Integer leaseCount;
    private Integer shortTermRentCount;
    private Boolean isBookmarked;
    private String batlRatio; // 용적률
    private String btlRatio; // 건폐율
    private Integer parkingPossibleCount; // 주차대수
    private float parkingCountByHousehold;
    private String constructionCompanyName; // 건설사
    private String heatMethodTypeCode; //난방
    private String heatFuelTypeCode;
    private String pyoengNames;
    private String managementOfficeTelNo;
    private String buildingRegister;
    private String address;
    private String roadAddressPrefix;
    private String roadZipCode;

    @OneToOne(mappedBy = "complexDetail")
    Complex complex;
}
