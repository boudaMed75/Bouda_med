package bouda.med.company.controller.Auth;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bouda.med.company.DTO.auth.AuthReq;
import bouda.med.company.DTO.auth.AuthRes;
import bouda.med.company.user.AuthService;
import bouda.med.company.user.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")

public class AuthController {

    @Autowired
    private AuthService authService ;

    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    
    private ResponseEntity<AuthRes> authentificate(@RequestBody AuthReq req){
        return ResponseEntity.ok(authService.authenticate(req));
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadUsers(@RequestParam("file") MultipartFile file) {
        try {
            userService.saveUsersFromJson(file);
            return ResponseEntity.ok("Les utilisateurs ont été insérés avec succès.");
        } catch (IOException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }


    
    

}
