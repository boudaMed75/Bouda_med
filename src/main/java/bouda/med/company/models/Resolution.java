package bouda.med.company.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity



public class Resolution {

    @Id
    private String id;

    private String title ; 

    private String description ;

    // RENION

    @ManyToOne
    @JoinColumn(name =  "objectif_id")
    private Objectif objectif ;
    

    
}
