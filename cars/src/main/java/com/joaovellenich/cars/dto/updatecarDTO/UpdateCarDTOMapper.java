package com.joaovellenich.cars.dto.updatecarDTO;

import com.joaovellenich.cars.domain.Car;

public class UpdateCarDTOMapper {
    public Car toCar(UpdateCarRequest request){
        return Car.builder()
                .id(request.id())
                .brand(request.brand())
                .model(request.model())
                .km(request.km())
                .year(request.year())
                .build();
    }

    public UpdateCarResponse toResponse(Car updatedCar){
        return UpdateCarResponse.builder()
                .id(updatedCar.id())
                .model(updatedCar.model())
                .brand(updatedCar.brand())
                .km(updatedCar.km())
                .year(updatedCar.year())
                .ownerId(updatedCar.ownerId())
                .build();
    }
}
