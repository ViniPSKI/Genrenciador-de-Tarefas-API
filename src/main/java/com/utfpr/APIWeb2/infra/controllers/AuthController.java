package com.utfpr.APIWeb2.infra.controllers;

import com.utfpr.APIWeb2.core.domain.User;
import com.utfpr.APIWeb2.infra.DTO.UserDto;
import com.utfpr.APIWeb2.infra.converters.UserMapper;
import com.utfpr.APIWeb2.infra.entity.UserEntity;
import com.utfpr.APIWeb2.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @Autowired
    private UserMapper userMapper;

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDto userDto){
        try{
            var userPassword = new UsernamePasswordAuthenticationToken(userDto.email(), userDto.password());
            var auth = this.authenticationManager.authenticate(userPassword);

            UserEntity userEntity = (UserEntity) auth.getPrincipal();
            User user = userMapper.toDomain(userEntity);

            String token = tokenService.generateToken(user);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            return ResponseEntity.ok(response);
        }catch (RuntimeException e){
            throw new BadCredentialsException("Invalid email or password");
        }catch (Exception e) {
            throw new RuntimeException("An error occurred during login: " + e.getMessage());
        }

    }

}
