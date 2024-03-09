package com.joaovellenich.cars.infra.controllers;


import com.joaovellenich.cars.application.usecases.CreateCarUseCase;
import com.joaovellenich.cars.domain.Car;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarDTOMapper;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarRequest;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CreateCarUseCase createCarUseCase;
    private final CreateCarDTOMapper createCarDTOMapper;
    public CarController(CreateCarUseCase createCarUseCase, CreateCarDTOMapper createCarDTOMapper){
        this.createCarUseCase = createCarUseCase;
        this.createCarDTOMapper = createCarDTOMapper;
    }
    @PostMapping("/")
    public ResponseEntity<CreateCarResponse> createCar(@RequestBody CreateCarRequest request){
        try {
            Car newCar = this.createCarDTOMapper.toCar(request);
            Car savedCar = this.createCarUseCase.createCar(newCar);
            return ResponseEntity.ok().body(this.createCarDTOMapper.toCreateCarResponse(savedCar));
        }catch (Exception error){
            System.out.println(error);
            return ResponseEntity.badRequest().build();
        }
    }
}
