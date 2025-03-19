package bouda.med.company.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class DemandeRenion {

    @Id
    private Long id;
    private String name ; 
    private String content ; 

    private String sous_module_id ;

    private String status ;

    
    
}
