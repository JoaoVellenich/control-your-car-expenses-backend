package com.joaovellenich.fuel.infra.controller;

import com.joaovellenich.fuel.application.usecases.CreateFuelUseCase;
import com.joaovellenich.fuel.application.usecases.GetAllFuelUseCase;
import com.joaovellenich.fuel.domain.Fuel;
import com.joaovellenich.fuel.dto.createfuelDTO.CreateFuelDTOMapper;
import com.joaovellenich.fuel.dto.createfuelDTO.CreateFuelRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fuel")
public class FuelController {
    private final static Logger logger = LoggerFactory.getLogger(FuelController.class);

    private final CreateFuelUseCase createFuelUseCase;
    private final CreateFuelDTOMapper ceCreateFuelDTOMapper;

    private final GetAllFuelUseCase getAllFuelUseCase;
    public FuelController(
            CreateFuelUseCase createFuelUseCase,
            CreateFuelDTOMapper ceCreateFuelDTOMapper,
            GetAllFuelUseCase getAllFuelUseCase
    ){
        this.createFuelUseCase = createFuelUseCase;
        this.ceCreateFuelDTOMapper = ceCreateFuelDTOMapper;
        this.getAllFuelUseCase = getAllFuelUseCase;
    }

    @PostMapping("/")
    public ResponseEntity createFuel(@RequestBody CreateFuelRequest fuel, HttpServletRequest servletRequest){
        try{
            logger.info("Start createFuel route - Request - "+ fuel);
            Fuel fuelDomain = this.ceCreateFuelDTOMapper.toFuel(fuel);
            String token = servletRequest.getHeader("Authorization").split("Bearer")[1];
            Fuel savedFuel = this.createFuelUseCase.createFuel(fuelDomain, token);
            logger.info("Finished createFuel route - Response - " + savedFuel);
            return ResponseEntity.ok().body(savedFuel);
        }catch (Exception error){
            logger.error("Error createFuel route - Error - " + error.getMessage());
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @GetMapping("/{carId}")
    public ResponseEntity getAllFuel(@PathVariable UUID carId) {
        logger.info("Start getAllFuel route - Request - " + carId);
        List<Fuel> fuel = this.getAllFuelUseCase.getAllFuel(carId);
        logger.info("Finished getAllUsers - Response - " + fuel);
        return ResponseEntity.ok().body(fuel);
    }

}
