package bouda.med.company.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.auth.AuthReq;
import bouda.med.company.DTO.auth.AuthRes;
import bouda.med.company.DTO.resgister.RegisterReq;
import bouda.med.company.DTO.resgister.RegisterRes;
import bouda.med.company.config.JwtService;
import bouda.med.company.token.Token;
import bouda.med.company.token.TokenType;

@Service
public class AuthService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private TokenDao tokenDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ModelMapper modelMapper;

    public RegisterRes register(RegisterReq request) {
        System.out.println(request.getPassword());
        System.out.println(request.getEmail());
        System.out.println(request.getPrenom());
        var user = User.builder()
            .nom(request.getNom())
            .prenom(request.getPrenom())
            .email(request.getEmail())
            .passWord(passwordEncoder.encode(request.getPassword()))
            .role(request.getRole())
            .build();
        var savedUser = userDao.save(user);
        
        return modelMapper.map(savedUser, RegisterRes.class);
    }
    public AuthRes authenticate(AuthReq request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );
        var user = userDao.findByEmail(request.getUsername())
            .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        var response = AuthRes.builder()
                        .nom(user.getNom())
                        .prenom(user.getPrenom())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .accessToken(jwtToken)
                        .refreshToken(refreshToken)
                        .build();
        return response;

  }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
            .user(user)
            .token(jwtToken)
            .tokenType(TokenType.BEARER)
            .expired(false)
            .revoked(false)
            .build();
        tokenDao.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenDao.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
          return;
        validUserTokens.forEach(token -> {
          token.setExpired(true);
          token.setRevoked(true);
        });
        tokenDao.saveAll(validUserTokens);
    }





    
}
