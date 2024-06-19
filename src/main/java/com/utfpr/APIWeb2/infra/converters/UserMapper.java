package com.utfpr.APIWeb2.infra.converters;

import com.utfpr.APIWeb2.core.domain.User;
import com.utfpr.APIWeb2.infra.DTO.UserDto;
import com.utfpr.APIWeb2.infra.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user){
        return new UserDto(user.getEmail(), user.getPassword());
    }

    public User toSave(UserDto userDto){
        return new User(userDto.email(), userDto.password());
    }

    public User toDomain(UserEntity userEntity){
        return new User(userEntity.getEmail(), userEntity.getPassword());
    }

}
