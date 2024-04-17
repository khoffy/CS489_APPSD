package edu.miu.cs.cs489appsd.securityservice.web;

import edu.miu.cs.cs489appsd.securityservice.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class AuthController {

    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> jwtToken(String grantType, String username, String password,
                                                        boolean withRefreshToken, String refreshToken) {
        ResponseEntity<Map<String, String>> responseEntity;

        Map<String, String> idToken = authService.jwtToken(grantType, username, password, withRefreshToken, refreshToken);

        if(idToken.containsKey("errorMessage")) {
            responseEntity = new ResponseEntity<>(idToken, HttpStatus.UNAUTHORIZED);
        } else {
            responseEntity = new ResponseEntity<>(idToken, HttpStatus.OK);
        }
        return responseEntity;
    }
}
