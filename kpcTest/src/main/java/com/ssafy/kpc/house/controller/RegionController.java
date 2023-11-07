package com.ssafy.kpc.house.controller;

import com.ssafy.kpc.house.model.dto.RegionDto;
import com.ssafy.kpc.house.model.entity.Region;
import com.ssafy.kpc.house.model.service.RegionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/region")
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/list/{cortarNo}")
    public ResponseEntity<List<Region>> regionDtoList(@PathVariable Long cortarNo){
        List<Region> regionList = regionService.regionDtoList(cortarNo);
        return new ResponseEntity<List<Region>>(regionList, HttpStatus.OK);
    }

}
