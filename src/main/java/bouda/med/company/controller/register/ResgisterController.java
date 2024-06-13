package bouda.med.company.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bouda.med.company.DTO.resgister.RegisterReq;
import bouda.med.company.DTO.resgister.RegisterRes;
import bouda.med.company.user.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
public class ResgisterController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterRes> register(@RequestBody RegisterReq req){
        return ResponseEntity.ok(authService.register(req));
    }
    
}
