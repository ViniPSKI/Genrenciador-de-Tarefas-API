package com.utfpr.APIWeb2.infra.persistence.repository;

import com.utfpr.APIWeb2.infra.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    boolean existsByEmail(String email);
    UserDetails findByEmail(String email);
    UserEntity findUserEntityByEmail(String email);
}
