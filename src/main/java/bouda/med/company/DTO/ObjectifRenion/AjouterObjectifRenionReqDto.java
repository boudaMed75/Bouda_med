package bouda.med.company.DTO.ObjectifRenion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AjouterObjectifRenionReqDto {

    private String titre ;

    private String description ;

    private String renion ;
    
}
