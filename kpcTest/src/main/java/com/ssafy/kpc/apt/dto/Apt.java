package com.ssafy.kpc.apt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
////@Table(name = "apt")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Apt {

    private int amount;//거래금액
    private int buildYear;//건축년도
    private int dealYear; //년
    private int dealMonth; //월
    private int dealDay; //일
    private int sigunguCode; //법정동시군구코드
    private int eupmyundongCode; //법정동읍면동코드
    private String sigungu; //중개사소재지
    private String dong; //법정동
    private String aptName; //아파트
    private double dedicatedArea; //전용면적
    private int floor; //층

}
