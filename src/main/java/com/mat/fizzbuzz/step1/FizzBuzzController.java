package com.mat.fizzbuzz.step1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class FizzBuzzController {

    private FizzBuzzService fizzBuzzService;

    @Autowired
    public void setFizzBuzzService(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping(value = "/transformation")
    public ResponseEntity<Resp> getTransformation(@RequestParam int startInterval, @RequestParam int endInterval){
        String[] transformation = fizzBuzzService.transform(startInterval, endInterval);
        Resp response = Resp.builder()
                .transformation(fizzBuzzService.generateString(Arrays.asList(transformation)))
                .raport(fizzBuzzService.generateReport(Arrays.asList(transformation)))
                .build();
        return ResponseEntity.status(200).body(response);

    }
}
