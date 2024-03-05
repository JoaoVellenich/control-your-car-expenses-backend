package com.joaovellenich.cars.modules.cars.controllers;

import com.joaovellenich.cars.infra.security.TokenService;
import com.joaovellenich.cars.modules.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cars")
public class CarsController {
    @Autowired
    private TokenService tokenService;
    @GetMapping("/createCar")
    public ResponseEntity getAllCars(){
        try{
            var user = this.tokenService.getUsr();
            System.out.println(user);
            return ResponseEntity.ok().body(user);
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
