package com.utfpr.APIWeb2.core.usecase;

import com.utfpr.APIWeb2.core.domain.User;

import java.util.UUID;

public interface DeleteUserUseCase {

    User deleteUser(String email);

}
