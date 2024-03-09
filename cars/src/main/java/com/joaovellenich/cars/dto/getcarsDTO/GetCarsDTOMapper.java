package com.joaovellenich.cars.dto.getcarsDTO;

import com.joaovellenich.cars.domain.User;
import com.joaovellenich.cars.infra.security.TokenService;

import java.util.UUID;

public class GetCarsDTOMapper {
    public UUID getOwnerUUID() throws Exception {
        User user = new TokenService().getUsr();
        return user.id();
    }
}
