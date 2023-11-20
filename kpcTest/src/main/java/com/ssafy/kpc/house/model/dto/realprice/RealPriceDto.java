package com.ssafy.kpc.house.model.dto.realprice;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RealPriceDto {

    private Long realPriceNo;
    private String tradeType;
    private String tradeYear;
    private int tradeMonth;
    private String tradeDate;
    private Long dealPrice;

}
