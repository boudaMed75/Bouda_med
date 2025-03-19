package bouda.med.company.models;

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

public class Chapitre {

    
    @Id
    private String id;
    private String name ;
    private String description ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sous_module_id")
    private SousModules sousModules;


    @OneToMany(mappedBy = "chapitre",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Taches> taches;
    
}
