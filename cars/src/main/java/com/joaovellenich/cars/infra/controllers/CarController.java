package com.joaovellenich.cars.infra.controllers;


import com.joaovellenich.cars.application.usecases.CreateCarUseCase;
import com.joaovellenich.cars.application.usecases.GetCarByOwnerIdUseCase;
import com.joaovellenich.cars.domain.Car;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarDTOMapper;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarRequest;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarResponse;
import com.joaovellenich.cars.dto.getcarsDTO.GetCarsDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CreateCarUseCase createCarUseCase;
    private final CreateCarDTOMapper createCarDTOMapper;
    private final GetCarByOwnerIdUseCase getCarByOwnerIdUseCase;
    private final GetCarsDTOMapper getCarsDTOMapper;
    public CarController(
            CreateCarUseCase createCarUseCase,
            CreateCarDTOMapper createCarDTOMapper,
            GetCarByOwnerIdUseCase getCarByOwnerIdUseCase,
            GetCarsDTOMapper getCarsDTOMapper
    ){
        this.createCarUseCase = createCarUseCase;
        this.createCarDTOMapper = createCarDTOMapper;
        this.getCarByOwnerIdUseCase = getCarByOwnerIdUseCase;
        this.getCarsDTOMapper = getCarsDTOMapper;
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

    @GetMapping("/")
    public ResponseEntity<List<Car>> getCarsByOwnerId(){
        try{
            UUID ownerId = this.getCarsDTOMapper.getOwnerUUID();
            List<Car> cars = this.getCarByOwnerIdUseCase.getCarByOwnerId(ownerId);
            return ResponseEntity.ok().body(cars);
        }catch (Exception error){
            System.out.println(error);
            return ResponseEntity.badRequest().build();
        }
    }
}
