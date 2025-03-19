package bouda.med.company.DTO.projet;

import java.util.Date;
import java.util.List;

import bouda.med.company.DTO.modules.ModuleResSimple;
import bouda.med.company.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectResDto {

    private String id;
    private String name;
    private String description;
    private Date start_date ;
    private Date end_date ;
    private boolean is_active ;

    private User user;

    private List<ModuleResSimple> moduleResSimples;


}
