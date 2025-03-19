package bouda.med.company.models;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

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

public class ResultatRenion {

    @Id
    private String id;

    private String title ;

    private String description ; 

    private Date date_start ;

    private Date date_end ;

    

    // Demande
    @ManyToOne
    @JoinColumn(name = "demande_id")
    private DemandeEn resDemande ;

    // MECANISME A SUIVRE
    @OneToMany(mappedBy = "result",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MecanismSuivre> mecanismSuivres;
    
}
