package bouda.med.company.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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

public class SousModules {

    @Id
    private String id;

    private String name ;
    private String description ;
    private Date start_date ;
    private Date end_date ;
    private Boolean active ;
    private Double note_sous_module ;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Modules module ;

    @OneToMany(mappedBy = "sousModules",cascade = CascadeType.ALL)
    private List<Chapitre> chapitres;

   
    
}
