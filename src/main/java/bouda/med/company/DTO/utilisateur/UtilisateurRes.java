package bouda.med.company.DTO.utilisateur;

import bouda.med.company.user.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UtilisateurRes {

    private String id ;
    private String nom ;
    private String prenom ;
    private String email ;
    private String code ;
    private Boolean is_active;
    private String profil_img;
    private Role role;
}
