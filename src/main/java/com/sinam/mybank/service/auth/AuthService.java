package com.sinam.mybank.service.auth;

import com.sinam.mybank.dao.entity.UserEntity;
import com.sinam.mybank.dao.repository.UserRepository;
import com.sinam.mybank.mapper.UserMapper;
import com.sinam.mybank.model.auth.UserRegisterRequestDto;
import com.sinam.mybank.model.auth.AuthRequestDto;
import com.sinam.mybank.model.auth.AuthenticationResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authManager = authManager;
    }

    public AuthenticationResponse register(UserRegisterRequestDto requestDto) {
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        var user = UserMapper.INSTANCE.mapUserRequestDtoToEntity(requestDto);

        userRepository.save(user);

        Map<String,Object> userMap = new HashMap<>();
        userMap.put("id",user.getId());
        var jwtToken = jwtService.generateToken(userMap,user);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);
        return authenticationResponse;
    }

    public AuthenticationResponse authenticate(AuthRequestDto authRequestDto) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.getEmail(),
                        authRequestDto.getPassword()
                )
        );

        UserEntity user = userRepository.findUserByEmail(authRequestDto.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);
        return authenticationResponse;
    }

    public static UserEntity getUser() {
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
