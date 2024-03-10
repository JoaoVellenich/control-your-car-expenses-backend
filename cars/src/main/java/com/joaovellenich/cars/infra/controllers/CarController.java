package com.joaovellenich.cars.infra.controllers;


import com.joaovellenich.cars.application.usecases.CreateCarUseCase;
import com.joaovellenich.cars.application.usecases.GetCarByOwnerIdUseCase;
import com.joaovellenich.cars.domain.Car;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarDTOMapper;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarRequest;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarResponse;
import com.joaovellenich.cars.dto.getcarsDTO.GetCarsDTOMapper;
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
            logger.info("Start creatingCar route - Request - " + request);
            Car newCar = this.createCarDTOMapper.toCar(request);
            Car savedCar = this.createCarUseCase.createCar(newCar);
            logger.info("Finished createCar route");
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
            logger.info(("Finished getCarsByOwnerId route"));
            return ResponseEntity.ok().body(cars);
        }catch (Exception error){
            logger.error("Error getCarsByOwnerId route - Error - " + error);
            return ResponseEntity.badRequest().build();
        }
    }
}
