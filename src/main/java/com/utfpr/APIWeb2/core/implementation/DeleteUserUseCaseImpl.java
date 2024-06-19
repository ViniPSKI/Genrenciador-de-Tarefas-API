package com.utfpr.APIWeb2.core.implementation;

import com.utfpr.APIWeb2.core.domain.User;
import com.utfpr.APIWeb2.core.ports.UserService;
import com.utfpr.APIWeb2.core.usecase.DeleteUserUseCase;

public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private UserService userService;

    public DeleteUserUseCaseImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User deleteUser(String email) {
        return userService.deleteUser(email);
    }
}
