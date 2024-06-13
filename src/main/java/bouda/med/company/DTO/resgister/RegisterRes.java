package bouda.med.company.DTO.resgister;

import bouda.med.company.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RegisterRes {
    private Long id ;
    private String nom ;
    private String prenom ;
    private String email ;
    private String passWord ;
    private Role role;
}
