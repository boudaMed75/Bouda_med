package bouda.med.company.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class DemandeEn {

    @Id
    private String id;

    private String titre ;

    private String description ; 

    private Date date_demande ; 

    private boolean acceptation ;

    private Date date_acceptation ;

    // Renion

    @ManyToOne
    @JoinColumn(name = "renion_id")
    private Renion demandeRenion ;

    // MODULE
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Modules demandedModel;


    // RESULT

    @OneToMany(mappedBy = "resDemande",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ResultatRenion> resultatRenions ;

    

    

    
}
