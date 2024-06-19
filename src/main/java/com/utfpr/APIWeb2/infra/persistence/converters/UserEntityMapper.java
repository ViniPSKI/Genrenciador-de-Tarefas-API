package com.utfpr.APIWeb2.infra.persistence.converters;

import com.utfpr.APIWeb2.core.domain.User;
import com.utfpr.APIWeb2.infra.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UserEntity toEntity(User user){
        return new UserEntity(user.getId(), user.getEmail(), user.getPassword());
    }

    public User toUser(UserEntity userEntity){
        return new User(userEntity.getEmail(), userEntity.getPassword());
    }

}
