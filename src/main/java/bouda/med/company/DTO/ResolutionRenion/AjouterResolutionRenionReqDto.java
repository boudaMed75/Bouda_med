package bouda.med.company.DTO.ResolutionRenion;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AjouterResolutionRenionReqDto {
    private String title ;

    private String description ; 

    private Date date_start ;

    private Date date_end ;

    private String objectif ;


}
