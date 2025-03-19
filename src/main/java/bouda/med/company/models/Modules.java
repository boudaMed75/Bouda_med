package bouda.med.company.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import bouda.med.company.user.User;
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

public class Modules {

    @Id
    private String id;
    private String name ;
    private String description ;
    private Date start_date;
    private Date end_date ;
    private Boolean is_active ;
    private Double note_mo;
    private String code_module ;
    private String type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User encadrant;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projet projet;

    @OneToMany(mappedBy = "module" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<SousModules> sousModules;

    @OneToMany(mappedBy = "demandedModel",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<DemandeEn> demandeEns ;
    
}
