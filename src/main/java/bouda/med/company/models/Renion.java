package bouda.med.company.models;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
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
public class Renion {

    @Id
    private String id;

    private Date date ;

    private String titre ;

    private String type ; 


    @Column(name = "heure", nullable = false)
    private LocalTime dateHeure;

    @Column(name = "lieu", length = 200)
    private String lieu;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "projet_id")
    private Projet projetRenion;


    // OBJECTIF
    @OneToMany(mappedBy = "objRenion",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Objectif> objectifs ;

    // DemandeEN
    @OneToMany(mappedBy = "demandeRenion",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<DemandeEn> demandeEns;

    

    

   // private List<Objectif> Objectifs ;


    
     
    
}

