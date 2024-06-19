package com.utfpr.APIWeb2.infra.controllers;

import com.utfpr.APIWeb2.core.exceptions.CreateUserException;
import com.utfpr.APIWeb2.core.usecase.CreateUserUseCase;
import com.utfpr.APIWeb2.core.usecase.DeleteUserUseCase;
import com.utfpr.APIWeb2.core.usecase.GetUserUseCase;
import com.utfpr.APIWeb2.infra.DTO.UserDto;
import com.utfpr.APIWeb2.infra.converters.UserMapper;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UserMapper userMapper;
    private final DeleteUserUseCase deleteUserUseCase;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDtoRequest) throws CreateUserException {
        String encryptPassword = new BCryptPasswordEncoder().encode(userDtoRequest.password());
        var userDto = new UserDto(userDtoRequest.email(), encryptPassword);

        var userSave = userMapper.toSave(userDto);
        var userCreate = createUserUseCase.createUser(userSave);
        return userMapper.toDto(userCreate);
    }

    @GetMapping("/{email}")
    public UserDto getUser(@PathVariable(value = "email") String email){
        var user = getUserUseCase.findUser(email);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "email") String email){
        var userDeleted = deleteUserUseCase.deleteUser(email);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted success");
    }

    @PutMapping("/{email}")
    public ResponseEntity<Object> editUser(@PathVariable(value = "email") String email, @RequestBody UserDto userDtoRequest){
        String encryptPassword = new BCryptPasswordEncoder().encode(userDtoRequest.password());
        var userDto = new UserDto(userDtoRequest.email(), encryptPassword);
        var userSave = userMapper.toSave(userDto);

        var userEdited = createUserUseCase.editUser(email, userSave);

        return ResponseEntity.status(HttpStatus.OK).body(userEdited);
    }

}
