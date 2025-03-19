package bouda.med.company.DTO.modules;

import java.util.Date;

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
public class ModuleResSimple {

    private String id ;
    private String name ;
    private String description ;
    private Date start_date;
    private Date end_date ;
    private Boolean is_active ;
    private Double note_mo;

    private User user;
    private String project_name ;
    private String project_id ;
    
}
