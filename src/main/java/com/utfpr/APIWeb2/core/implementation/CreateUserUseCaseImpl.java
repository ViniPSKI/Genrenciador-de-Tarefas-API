package com.utfpr.APIWeb2.core.implementation;

import com.utfpr.APIWeb2.core.domain.User;
import com.utfpr.APIWeb2.core.exceptions.CreateUserException;
import com.utfpr.APIWeb2.core.exceptions.enums.CreateUserExceptionEnum;
import com.utfpr.APIWeb2.core.ports.EmailService;
import com.utfpr.APIWeb2.core.ports.UserService;
import com.utfpr.APIWeb2.core.usecase.CreateUserUseCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserService userService;
    private final EmailService emailService;

    public CreateUserUseCaseImpl(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @Override
    public User createUser(User user) throws CreateUserException {
        if(emailService.findEmail(user.getEmail())){
            throw new CreateUserException(CreateUserExceptionEnum.ER001);
        }
        return userService.saveUser(user);
    }

    @Override
    public User findUser(UUID id) {
        return userService.findUser(id);
    }

    @Override
    public User editUser(String email, User user) {
        return userService.editUser(email, user);
    }

}
