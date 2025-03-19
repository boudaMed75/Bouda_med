package bouda.med.company.models;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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


public class Objectif {

    @Id
    private String id;

    private String titre ;

    private String description ;


    @ManyToOne
    @JoinColumn(name = "renion_id")
    private Renion objRenion ;


    // RESOLUTION
    @OneToMany(mappedBy = "objectif",cascade = CascadeType.ALL)
    private List<Resolution> resolutions;

    

    
}
