package com.utfpr.APIWeb2.core.usecase;

import com.utfpr.APIWeb2.core.domain.User;

public interface GetUserUseCase {

    User findUser(String email);

}
