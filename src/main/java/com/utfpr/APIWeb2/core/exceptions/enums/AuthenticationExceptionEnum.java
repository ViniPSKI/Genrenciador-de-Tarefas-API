package com.utfpr.APIWeb2.core.exceptions.enums;

public enum AuthenticationExceptionEnum {

    ER001("Token de acesso inválido!", "ER001"),
    ;
    private String message;
    private String codeError;

    AuthenticationExceptionEnum(String message, String codeError) {
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
