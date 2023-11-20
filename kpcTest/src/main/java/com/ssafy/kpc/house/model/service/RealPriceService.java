package com.ssafy.kpc.house.model.service;

import com.ssafy.kpc.house.model.dto.realprice.RealPriceDto;
import com.ssafy.kpc.house.model.repository.RealPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RealPriceService {

    private final RealPriceRepository realPriceRepository;


    public List<RealPriceDto> getRealPrice(){
        List<RealPriceDto> realPriceDtoList = realPriceRepository.findAll();
        return realPriceDtoList;
    }

}
