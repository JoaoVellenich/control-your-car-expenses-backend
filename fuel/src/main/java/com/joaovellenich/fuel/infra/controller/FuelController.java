package com.joaovellenich.fuel.infra.controller;

import com.joaovellenich.fuel.application.usecases.CreateFuelUseCase;
import com.joaovellenich.fuel.application.usecases.EditFuelUseCase;
import com.joaovellenich.fuel.application.usecases.GetAllFuelUseCase;
import com.joaovellenich.fuel.domain.Fuel;
import com.joaovellenich.fuel.dto.createfuelDTO.CreateFuelDTOMapper;
import com.joaovellenich.fuel.dto.createfuelDTO.CreateFuelRequest;
import com.joaovellenich.fuel.dto.updatefuelDTO.UpdateFuelDTOMapper;
import com.joaovellenich.fuel.dto.updatefuelDTO.UpdateFuelRequest;
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

    private final EditFuelUseCase editFuelUseCase;
    private final UpdateFuelDTOMapper updateFuelDTOMapper;
    public FuelController(
            CreateFuelUseCase createFuelUseCase,
            CreateFuelDTOMapper ceCreateFuelDTOMapper,
            GetAllFuelUseCase getAllFuelUseCase,
            EditFuelUseCase editFuelUseCase,
            UpdateFuelDTOMapper updateFuelDTOMapper
    ){
        this.createFuelUseCase = createFuelUseCase;
        this.ceCreateFuelDTOMapper = ceCreateFuelDTOMapper;
        this.getAllFuelUseCase = getAllFuelUseCase;
        this.editFuelUseCase = editFuelUseCase;
        this.updateFuelDTOMapper = updateFuelDTOMapper;
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

    @GetMapping("/{fuelId}")
    public ResponseEntity getAllFuel(@PathVariable UUID fuelId) {
        logger.info("Start getAllFuel route - Request - " + fuelId);
        List<Fuel> fuel = this.getAllFuelUseCase.getAllFuel(fuelId);
        logger.info("Finished getAllUsers - Response - " + fuel);
        return ResponseEntity.ok().body(fuel);
    }

    @PatchMapping("/{fuelId}")
    public ResponseEntity updateFuel(@PathVariable UUID fuelId, @RequestBody UpdateFuelRequest request){
        try{
            logger.info("Start updateFuel route - Request - " + request);
            Fuel fuelToUpdate = this.updateFuelDTOMapper.toDomain(request, fuelId);
            Fuel updatedFuel = this.editFuelUseCase.editFuel(fuelId, fuelToUpdate);
            logger.info("Finished updateFuel route - Response - " + updatedFuel );
            return ResponseEntity.ok().body(updatedFuel);
        }catch (Exception error){
            logger.error("Error updateFuel - Error - " + error.getMessage());
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

}
