package bouda.med.company.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
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
public class Taches {

    @Id
    private String id;
    private String name ;
    private String description ;
    private Boolean completed;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "chapitre_id")
    private Chapitre chapitre;

    



    
}
