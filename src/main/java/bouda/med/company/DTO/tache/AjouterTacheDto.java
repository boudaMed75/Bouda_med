package bouda.med.company.DTO.tache;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AjouterTacheDto {

    private String name ;
    private String description ;
    private String chapitre;
    
}
