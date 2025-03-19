package bouda.med.company.DTO.utilisateur;

import org.springframework.web.multipart.MultipartFile;

import bouda.med.company.user.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AjouterReq {

    @NotBlank(message = "Ce Champ est obligatoire !!")
    @Size(min = 5, message = "ce champ doit avoir au moins 5 charactere")
    @Size(max = 20, message = "ce champs ne doit pas depasser 20 charactere")
    private String nom;


    @NotBlank(message = "Ce Champ est obligatoire !!")
    @Size(min = 5, message = "ce champ doit avoir au moins 5 character")
    @Size(max = 20, message = "ce champs ne doit pas depasser 20 charactere")
    private String prenom;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "email format invalid")
    private String email;

    @NotNull
    private String passWord ;

    @NotNull
    private Role role;

    @NotBlank(message = "Ce Champ est obligatoire !!")
    private MultipartFile imgs;
    
}
