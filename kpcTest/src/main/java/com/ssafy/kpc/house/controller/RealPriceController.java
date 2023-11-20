package com.ssafy.kpc.house.controller;

import com.ssafy.kpc.house.model.dto.RealPriceDto;
import com.ssafy.kpc.house.model.dto.realprice.RealPriceDto;
import com.ssafy.kpc.house.model.repository.RealPriceRepository;
import com.ssafy.kpc.house.model.service.RealPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/realprice")
public class RealPriceController {

    private final RealPriceService realPriceService;

    public RealPriceController(RealPriceService realPriceService) {
        this.realPriceService = realPriceService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<RealPriceDto>> test(){
        List<RealPriceDto> realPriceDtoList = realPriceService.getRealPrice();
        return new ResponseEntity<List<RealPriceDto>>(realPriceDtoList, HttpStatus.OK);
    }
}
