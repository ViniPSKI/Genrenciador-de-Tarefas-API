package com.utfpr.APIWeb2.core.implementation;

import com.utfpr.APIWeb2.core.domain.User;
import com.utfpr.APIWeb2.core.ports.UserService;
import com.utfpr.APIWeb2.core.usecase.GetUserUseCase;

public class GetUserUseCaseImpl implements GetUserUseCase {

    private final UserService userService;

    public GetUserUseCaseImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User findUser(String email) {
        return userService.findUserByEmail(email);
    }
}
