package com.utfpr.APIWeb2.core.exceptions;

import com.utfpr.APIWeb2.core.exceptions.enums.CreateUserExceptionEnum;

public class CreateUserException extends Exception{

    private String codeError;

    public CreateUserException(CreateUserExceptionEnum createUserExceptionEnum){
        super(createUserExceptionEnum.getMessage());
        this.codeError = createUserExceptionEnum.getCodeError();
    }

    public String getCodeError() {
        return codeError;
    }
}
