package bouda.med.company.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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

public class Participant {

    @Id
    @GeneratedValue
    private Long id;

    private String nom ;
    private String prenom ;
    private Date date_naiss ;
    private String adresse ;
    private String email ;
    private String telephone ;

    private Boolean status ;
    
    
}
