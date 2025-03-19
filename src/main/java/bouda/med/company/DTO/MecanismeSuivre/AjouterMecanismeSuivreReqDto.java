package bouda.med.company.DTO.MecanismeSuivre;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AjouterMecanismeSuivreReqDto {

    private String title ;

    private String description ;

    private String result ;
    
}
