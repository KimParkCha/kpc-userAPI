package com.ssafy.kpc.house.model.repository;

import com.ssafy.kpc.house.model.entity.region.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    public List<Region> findByCortarNo(Long cortarNo);
}
