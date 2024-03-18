package com.joaovellenich.fuel.infra.controller;

import com.joaovellenich.fuel.application.usecases.CreateFuelUseCase;
import com.joaovellenich.fuel.domain.Fuel;
import com.joaovellenich.fuel.dto.createfuelDTO.CreateFuelDTOMapper;
import com.joaovellenich.fuel.dto.createfuelDTO.CreateFuelRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fuel")
public class FuelController {
    private final static Logger logger = LoggerFactory.getLogger(FuelController.class);

    private final CreateFuelUseCase createFuelUseCase;
    private final CreateFuelDTOMapper ceCreateFuelDTOMapper;
    public FuelController(
            CreateFuelUseCase createFuelUseCase,
            CreateFuelDTOMapper ceCreateFuelDTOMapper
    ){
        this.createFuelUseCase = createFuelUseCase;
        this.ceCreateFuelDTOMapper = ceCreateFuelDTOMapper;
    }

    @PostMapping("/")
    public ResponseEntity createFuel(@RequestBody CreateFuelRequest request){
        logger.info("Start createFuel route - Request - "+ request);
        Fuel fuel = this.ceCreateFuelDTOMapper.toFuel(request);
        Fuel savedFuel = this.createFuelUseCase.createFuel(fuel);
        logger.info("Finished createFuel route - Response - " + savedFuel);
        return ResponseEntity.ok().body(savedFuel);
    }


}
