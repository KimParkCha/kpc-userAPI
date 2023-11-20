package com.ssafy.kpc.house.model.repository;

import com.ssafy.kpc.house.model.dto.realprice.RealPriceDto;
import com.ssafy.kpc.house.model.entity.complex.Complex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RealPriceRepository extends JpaRepository<RealPriceDto, Long> {

}
