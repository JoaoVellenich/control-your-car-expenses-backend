package com.joaovellenich.cars.infra.controllers;


import com.joaovellenich.cars.application.usecases.*;
import com.joaovellenich.cars.domain.Car;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarDTOMapper;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarRequest;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarResponse;
import com.joaovellenich.cars.dto.getcarsDTO.GetCarsDTOMapper;
import com.joaovellenich.cars.dto.updatecarDTO.UpdateCarDTOMapper;
import com.joaovellenich.cars.dto.updatecarDTO.UpdateCarRequest;
import com.joaovellenich.cars.dto.updatecarDTO.UpdateCarResponse;
import com.joaovellenich.cars.dto.updatekmDTO.UpdateKmRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
public class CarController {
    private static Logger logger = LoggerFactory.getLogger(CarController.class);
    private final CreateCarUseCase createCarUseCase;
    private final CreateCarDTOMapper createCarDTOMapper;
    private final GetCarByOwnerIdUseCase getCarByOwnerIdUseCase;
    private final GetCarsDTOMapper getCarsDTOMapper;
    private final DeleteCarUseCase deleteCarUseCase;
    private final UpdateCarUseCase updateCarUseCase;
    private final UpdateCarDTOMapper updateCarDTOMapper;
    private final UpdateCarKmUseCase updateCarKmUseCase;
    public CarController(
            CreateCarUseCase createCarUseCase,
            CreateCarDTOMapper createCarDTOMapper,
            GetCarByOwnerIdUseCase getCarByOwnerIdUseCase,
            GetCarsDTOMapper getCarsDTOMapper,
            DeleteCarUseCase deleteCarUseCase,
            UpdateCarUseCase updateCarUseCase,
            UpdateCarDTOMapper updateCarDTOMapper,
            UpdateCarKmUseCase updateCarKmUseCase
    ){
        this.createCarUseCase = createCarUseCase;
        this.createCarDTOMapper = createCarDTOMapper;
        this.getCarByOwnerIdUseCase = getCarByOwnerIdUseCase;
        this.getCarsDTOMapper = getCarsDTOMapper;
        this.deleteCarUseCase = deleteCarUseCase;
        this.updateCarUseCase = updateCarUseCase;
        this.updateCarDTOMapper = updateCarDTOMapper;
        this.updateCarKmUseCase = updateCarKmUseCase;
    }
    @PostMapping("/")
    public ResponseEntity<CreateCarResponse> createCar(@RequestBody CreateCarRequest request){
        try {
            logger.info("Start creatingCar route - Request - " + request);
            Car newCar = this.createCarDTOMapper.toCar(request);
            Car savedCar = this.createCarUseCase.createCar(newCar);
            logger.info("Finished createCar route - successes");
            return ResponseEntity.ok().body(this.createCarDTOMapper.toCreateCarResponse(savedCar));
        }catch (Exception error){
            logger.error("Error createCar route - Error - " + error);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Car>> getCarsByOwnerId(){
        try{
            logger.info("Start getCarsByOwnerId route ");
            UUID ownerId = this.getCarsDTOMapper.getOwnerUUID();
            List<Car> cars = this.getCarByOwnerIdUseCase.getCarByOwnerId(ownerId);
            logger.info(("Finished getCarsByOwnerId route - successes"));
            return ResponseEntity.ok().body(cars);
        }catch (Exception error){
            logger.error("Error getCarsByOwnerId route - Error - " + error);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity deleteCar(@PathVariable UUID carId){
        try{
            logger.info("Start deleteCar route - carId - " + carId);
            UUID ownerId = this.getCarsDTOMapper.getOwnerUUID();
            this.deleteCarUseCase.deleteCar(carId, ownerId);
            logger.info("Finished deleteCar route - successes");
            return ResponseEntity.ok().build();
        }catch (Exception error){
            logger.error("Error deleteCar route - Error - " + error);
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PatchMapping("/")
    public ResponseEntity<UpdateCarResponse> updateCar(@RequestBody UpdateCarRequest request){
        try{
            logger.info("Start updateCar - Request - " + request);
            UUID ownerId = this.getCarsDTOMapper.getOwnerUUID();
            Car updatedCar = this.updateCarDTOMapper.toCar(request);
            Car endCar = this.updateCarUseCase.updateCar(updatedCar, ownerId);
            UpdateCarResponse response = this.updateCarDTOMapper.toResponse(endCar);
            logger.info("Finished updateCar - Response - " + response);
            return ResponseEntity.ok().body(response);
        }catch (Exception error){
            logger.error("Error updateCar - Error - " + error);
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/updateKm")
    public ResponseEntity updateCarKm(@RequestBody UpdateKmRequest request){
        try {
            logger.info("Start updateCarKm - Request - " + request);
            UUID ownerId = this.getCarsDTOMapper.getOwnerUUID();
            Car updatedCar = this.updateCarKmUseCase.UpdateCarKm(request.carId(), ownerId, request.km());
            logger.info("Finished updateCarKm - Response - " + updatedCar);
            return ResponseEntity.ok().body(updatedCar);
        }catch (Exception error){
            logger.error("Error updateCarKm - " + error);
            return ResponseEntity.badRequest().body(error);
        }
    }
}
