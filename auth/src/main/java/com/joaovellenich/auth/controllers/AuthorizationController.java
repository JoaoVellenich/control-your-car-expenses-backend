package com.joaovellenich.auth.controllers;

import com.joaovellenich.auth.domain.user.UserEntity;
import com.joaovellenich.auth.domain.user.dto.AuthorizationUserDTO;
import com.joaovellenich.auth.domain.user.dto.RegisterUserDTO;
import com.joaovellenich.auth.domain.user.dto.TokenDTO;
import com.joaovellenich.auth.infra.security.TokenService;
import com.joaovellenich.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthorizationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthorizationUserDTO data){
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((UserEntity) auth.getPrincipal());

        return ResponseEntity.ok().body(new TokenDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterUserDTO data){
        if(this.userRepository.findByEmail(data.email())!=null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserEntity user = UserEntity.builder()
                .email(data.email())
                .name(data.name())
                .role(data.role())
                .password(encryptedPassword)
                .build();

        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }
}
