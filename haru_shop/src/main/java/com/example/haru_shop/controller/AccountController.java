package com.example.haru_shop.controller;

import com.example.haru_shop.config.JwtTokenUtil;
import com.example.haru_shop.config.JwtUserDetails;
import com.example.haru_shop.model.Account;
import com.example.haru_shop.reponse.JwtRequest;
import com.example.haru_shop.reponse.JwtResponse;
import com.example.haru_shop.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AccountService accountService;
//    @Autowired
//    private EmailService emailService;

    class ErrorInfo {
        private String error;
        private Long id;


    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> loginAuthentication(@RequestBody JwtRequest authenticationRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            JwtUserDetails principal = (JwtUserDetails) authentication.getPrincipal();
            GrantedAuthority authority = principal.getAuthorities().stream().findFirst().orElse(null);
            final String token = jwtTokenUtil.generateToken(principal.getUsername());

            return ResponseEntity.ok(new JwtResponse(token, principal.getUsername(), authority != null ? authority.getAuthority() : null));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Đăng nhập thất bại");
        }
    }
}