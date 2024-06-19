package com.utfpr.APIWeb2.infra.ports;

import com.utfpr.APIWeb2.core.ports.EmailService;
import com.utfpr.APIWeb2.infra.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailValidationRepositoryService implements EmailService {

    private final UserRepository userRepository;

    @Override
    public Boolean findEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
