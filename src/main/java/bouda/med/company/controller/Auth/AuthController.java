package bouda.med.company.controller.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bouda.med.company.DTO.auth.AuthReq;
import bouda.med.company.DTO.auth.AuthRes;
import bouda.med.company.user.AuthService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")

public class AuthController {

    @Autowired
    private AuthService authService ;

    @PostMapping("/authenticate")
    
    private ResponseEntity<AuthRes> authentificate(@RequestBody AuthReq req){
        return ResponseEntity.ok(authService.authenticate(req));
    }
    
}
