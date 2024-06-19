package com.utfpr.APIWeb2.core.ports;

import com.utfpr.APIWeb2.core.domain.User;

import java.util.UUID;

public interface UserService {

    User saveUser(User user);

    User findUser(UUID id);

    User deleteUser(String email);

    User editUser(String email, User user);

    User findUserByEmail(String email);

}
