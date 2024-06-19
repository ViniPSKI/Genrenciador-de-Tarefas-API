package com.utfpr.APIWeb2.core.exceptions.enums;

public enum CreateUserExceptionEnum {

    ER001("Email já cadastrado!", "ER001")

    ;
    private String message;
    private String codeError;

    CreateUserExceptionEnum(String message, String codeError) {
        this.message = message;
        this.codeError = codeError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCodeError() {
        return codeError;
    }

    public void setCodeError(String codeError) {
        this.codeError = codeError;
    }
}
