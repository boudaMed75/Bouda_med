package bouda.med.company.DTO.Eleve;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemandeEleveDto {

    private String nom ;
    private String prenom ;
    private Date date_naiss ;
    private String adresse ;
    private String email ;
    private String telephone ;
    
}
