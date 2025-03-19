package bouda.med.company.DTO.modules;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AjouterModuleDto {


    //private String id ;
    
    private String name ;
    private String description ;
    private Date start_date;
    private Date end_date ;
    private Boolean is_active ;
    private Double note_mo;

    private String user;
    private String pro;
}
