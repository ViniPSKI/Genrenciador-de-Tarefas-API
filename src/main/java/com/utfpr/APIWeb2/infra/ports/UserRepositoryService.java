package com.utfpr.APIWeb2.infra.ports;

import com.utfpr.APIWeb2.core.domain.User;
import com.utfpr.APIWeb2.core.ports.UserService;
import com.utfpr.APIWeb2.infra.entity.UserEntity;
import com.utfpr.APIWeb2.infra.persistence.converters.UserEntityMapper;
import com.utfpr.APIWeb2.infra.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Component
@Repository
@RequiredArgsConstructor
public class UserRepositoryService implements UserService {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User saveUser(User user) {
        var userEnt = userEntityMapper.toEntity(user);
        var userSave = userRepository.save(userEnt);
        return userEntityMapper.toUser(userSave);
    }

    @Override
    public User findUser(UUID id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        return userEntityMapper.toUser(userEntityOptional.get());
    }

    @Override
    public User deleteUser(String email) {
         UserEntity userEntity = userRepository.findUserEntityByEmail(email);
         userRepository.delete(userEntity);
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public User editUser(String email, User user) {

        UserEntity userEntityOptional = userRepository.findUserEntityByEmail(email);

        var userEdited = new User();
        BeanUtils.copyProperties(user, userEdited);
        userEdited.setId(userEntityOptional.getId());

        var userEntity = userEntityMapper.toEntity(userEdited);
        var userSaved = userRepository.save(userEntity);

        return userEntityMapper.toUser(userSaved);
    }

    @Override
    public User findUserByEmail(String email) {
        UserEntity userEntity = userRepository.findUserEntityByEmail(email);
        return userEntityMapper.toUser(userEntity);
    }

}
