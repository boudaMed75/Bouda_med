package bouda.med.company.DTO.modules;

import java.util.Date;
import java.util.List;

import bouda.med.company.DTO.SousModule.SousModulesSimpleResDto;
import bouda.med.company.DTO.projet.ProjectResSimpleDto;
import bouda.med.company.DTO.utilisateur.UtilisateurRes;
import bouda.med.company.models.Projet;
import bouda.med.company.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ModulesSousModulesResDto {

    private String id ;
    private String name ;
    private String description ;
    private Date start_date;
    private Date end_date ;
    private Boolean is_active ;
    private Double note_mo;


    private UtilisateurRes user;
    private ProjectResSimpleDto projet;

    private List<SousModulesSimpleResDto> sousModules;

}
