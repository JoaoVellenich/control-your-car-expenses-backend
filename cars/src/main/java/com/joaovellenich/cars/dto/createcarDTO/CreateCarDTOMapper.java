package com.joaovellenich.cars.dto.createcarDTO;

import com.joaovellenich.cars.domain.Car;
import com.joaovellenich.cars.domain.User;
import com.joaovellenich.cars.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateCarDTOMapper {
    public Car toCar(CreateCarRequest car) throws Exception {
        User user = new TokenService().getUsr();
        return Car.builder()
                .brand(car.brand())
                .model(car.model())
                .km(car.km())
                .year(car.year())
                .ownerId(user.id())
                .build();
    }

    public CreateCarResponse toCreateCarResponse(Car car){
        return CreateCarResponse.builder()
                .id(car.id())
                .brand(car.brand())
                .model(car.model())
                .km(car.km())
                .year(car.year())
                .ownerId(car.ownerId())
                .build();
    }
}
