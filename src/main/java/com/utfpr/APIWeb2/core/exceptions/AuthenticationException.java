package com.utfpr.APIWeb2.core.exceptions;

import com.utfpr.APIWeb2.core.exceptions.enums.AuthenticationExceptionEnum;
import com.utfpr.APIWeb2.core.exceptions.enums.CreateUserExceptionEnum;

public class AuthenticationException extends Exception{
    private String codeError;

    public AuthenticationException(AuthenticationExceptionEnum authenticationExceptionEnum){
        super(authenticationExceptionEnum.getMessage());
        this.codeError = authenticationExceptionEnum.getCodeError();
    }

    public String getCodeError() {
        return codeError;
    }

}
