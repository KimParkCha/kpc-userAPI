package com.ssafy.kpc.house.model.entity.realPrice;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RealPrice {
    Long complexNo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long realPriceNo;

    String tradeYear;
    Integer tradeMonth;
    String tradeType;
    String tradeDate;
    Integer dealPrice;
    Integer floor;
    Float representativeArea;
    Float exclusiveArea;
    String formattedPricce;
    String formattedTradeYearMonth;
}

