package bouda.med.company.models;


import java.util.Date;

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


public class MecanismSuivre {

    @Id
    private String id;

    private String title ;

    private String description ;

    private Date date_finish ;

    private Boolean is_finished ;

    private Boolean is_faied ;

    // Result 
    @ManyToOne
    @JoinColumn(name = "result_id")
    private ResultatRenion result ;

    

    
}
