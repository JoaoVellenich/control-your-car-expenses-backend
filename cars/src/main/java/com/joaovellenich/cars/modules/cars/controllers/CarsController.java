package com.joaovellenich.cars.modules.cars.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cars")
public class CarsController {
    @GetMapping("/getCars")
    public ResponseEntity getAllCars(){
        return ResponseEntity.ok().body("Teste");
    }
}
