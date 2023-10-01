package com.sinam.mybank.controller;//package com.sinam.bank.controller;
//
//import com.dukan.model.AuthRequestDto;
//import com.dukan.model.AuthenticationResponse;
//import com.dukan.model.UserRegisterRequestDto;
//import com.dukan.service.auth.AuthService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/v1/auth")
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final AuthService authService;
//
//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody UserRegisterRequestDto requestDto
//    ) {
//        return ResponseEntity.ok(authService.register(requestDto));
//    }
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody AuthRequestDto authRequestDto
//    ) {
//        return ResponseEntity.ok(authService.authenticate(authRequestDto));
//    }
//}
