package com.utfpr.APIWeb2.core.usecase;

import com.utfpr.APIWeb2.core.domain.User;
import com.utfpr.APIWeb2.core.exceptions.CreateUserException;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CreateUserUseCase {

    User createUser(User user) throws CreateUserException;

    User findUser(UUID id);

    User editUser(String email, User user);

}
