package com.utfpr.APIWeb2.core.implementation;

import com.utfpr.APIWeb2.core.ports.EmailService;
import com.utfpr.APIWeb2.core.usecase.EmailValidationUseCase;

public class EmailValidationUseCaseImpl implements EmailValidationUseCase {

    private final EmailService emailService;

    public EmailValidationUseCaseImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public Boolean isValid(String email) {
        return emailService.findEmail(email);
    }
}
