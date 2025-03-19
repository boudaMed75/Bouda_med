package bouda.med.company.models;

import java.util.Date;
import java.util.List;

import bouda.med.company.user.User;
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
public class Projet {

    
    @Id
    private String projectID ;

    private String name;
    private String description;
    private Date start_date ;
    private Date end_date ;
    private boolean is_active ;
    private Double note ;

    @ManyToOne
    @JoinColumn(name = "chef_pro")
    private User chef;


    @OneToMany(mappedBy = "projet",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Modules> modules;

    @OneToMany(mappedBy = "projetRenion",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Renion> renions ;
    
}
