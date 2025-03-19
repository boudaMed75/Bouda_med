package bouda.med.company.DTO.DemandeEn;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AjouterDemandeEnReqDto {

    private String titre ;

    private String description ; 

    private String module ;

    
}
