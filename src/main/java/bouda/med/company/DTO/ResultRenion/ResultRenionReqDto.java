package bouda.med.company.DTO.ResultRenion;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ResultRenionReqDto {


    private String title ;

    private String description ; 

    private Date date_start ;

    private Date date_end ;

    private String demande ;

    
    
}
