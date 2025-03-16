package com.metinemre.service;

import com.metinemre.dto.request.LoginResponseDto;
import com.metinemre.dto.request.RegisterRequestDto;
import com.metinemre.entity.Auth;
import com.metinemre.manager.UserProfileManager;
import com.metinemre.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;

    public Auth register(RegisterRequestDto dto) {
        Auth auth = repository.save(Auth.builder()
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());

    }
    public ResponseEntity<Boolean> login(LoginResponseDto dto) {
        return ResponseEntity.ok(repository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword()));
    }

}
