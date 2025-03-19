package bouda.med.company.DTO.projet;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AjouterProjetDto {

    private String name;
    private String description;
    private Date start_date ;
    private Date end_date ;
    private boolean is_active ;
    // private Double note ;
    private String user_id ;
    
}
