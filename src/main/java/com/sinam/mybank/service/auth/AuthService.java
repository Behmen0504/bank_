package com.sinam.mybank.service.auth;//package com.sinam.bank.service.auth;
//
//
//import com.dukan.dao.entity.UserEntity;
//import com.dukan.dao.repository.UserRepository;
//import com.dukan.model.AuthRequestDto;
//import com.dukan.model.AuthenticationResponse;
//import com.dukan.model.UserRegisterRequestDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private JwtService jwtService;
//    @Autowired
//    private AuthenticationManager authManager;
//    public AuthenticationResponse register(UserRegisterRequestDto requestDto) {
//        var user = UserEntity.builder()
//                .name(requestDto.getFirstname())
//                .surname(requestDto.getLastname())
//                .email(requestDto.getEmail())
//                .password(passwordEncoder.encode(requestDto.getPassword()))
//                .build();
//
//        userRepository.save(user);
//
//        Map<String,Object> userMap = new HashMap<>();
//        userMap.put("id",user.getId());
//        var jwtToken = jwtService.generateToken(userMap,user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }
//
//    public AuthenticationResponse authenticate(AuthRequestDto authRequestDto) {
//        authManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        authRequestDto.getEmail(),
//                        authRequestDto.getPassword()
//                )
//        );
//
//        UserEntity user = userRepository.findUserByEmail(authRequestDto.getEmail()).orElseThrow();
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }
//
//    public static Object getUser() {
//        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    }
//}
