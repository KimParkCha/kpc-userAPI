//package com.ssafy.kpc.batch;
//
//import com.ssafy.kpc.house.model.dto.RegionDto;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.JobScope;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.json.JacksonJsonObjectReader;
//import org.springframework.batch.item.json.JsonItemReader;
//import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//@RequiredArgsConstructor
//@Slf4j
//@Configuration
//public class JsonJob1 {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//    private static final int chunkSize = 5;
//
//    @Bean
//    public Job jsonJob1_batchBuild(){
//        return jobBuilderFactory.get("jsonJob1").start(jsonJob1_batchStep1()).build();
//    }
//
//    @Bean
//    @JobScope
//    public Step jsonJob1_batchStep1(){
//        return stepBuilderFactory.get("jsonJob1_batchStep1")
//                .<RegionDto, RegionDto>chunk(chunkSize)
//                .reader(jsonJob1_jsonReader())
//                .writer(RegionDtos -> RegionDtos.stream().forEach(RegionDtos2 ->{
//                    log.debug(RegionDtos2.toString());
//                })).build();
//    }
//
//    @Bean
//    @StepScope
//    public JsonItemReader<RegionDto> jsonJob1_jsonReader(){
//        return new JsonItemReaderBuilder<RegionDto>()
//                .jsonObjectReader(new JacksonJsonObjectReader<>(RegionDto.class))
//                .resource(new ClassPathResource("sample/sidata.json"))
//                .name("jsonJob1_jsonReader")
//                .build();
//    }
//}
