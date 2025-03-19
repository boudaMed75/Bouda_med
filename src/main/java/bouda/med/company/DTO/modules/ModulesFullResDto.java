package bouda.med.company.DTO.modules;

import java.util.Date;
import java.util.List;

import bouda.med.company.DTO.SousModule.SousModulesResDto;
import bouda.med.company.models.Projet;
import bouda.med.company.models.SousModules;
import bouda.med.company.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModulesFullResDto {

    private String name ;
    private String description ;
    private Date start_date;
    private Date end_date ;
    private Boolean is_active ;
    private Double note_mo;

    private User user;
    private Projet projet;

    private List<SousModulesResDto> modulesResDtos;
    
}
