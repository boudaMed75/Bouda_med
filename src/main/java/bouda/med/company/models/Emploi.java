package bouda.med.company.models;

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
public class Emploi {

    @Id
    @GeneratedValue
    private Long id;
    private String content ;
    private String jour ;
    private String heure ;
    
}
