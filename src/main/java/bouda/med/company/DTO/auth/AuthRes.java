package bouda.med.company.DTO.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import bouda.med.company.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AuthRes {
    private String nom ;
    private String prenom ;
    private String email ;
    private Role role;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
}
