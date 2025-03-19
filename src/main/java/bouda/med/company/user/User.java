package bouda.med.company.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import bouda.med.company.models.Modules;
import bouda.med.company.models.PhotoProfil;
import bouda.med.company.models.Projet;
import bouda.med.company.token.Token;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "encadrants")



public class User implements UserDetails{

    @Id
    private String id;

    private String nom ;
    private String prenom ;

    
    @Column(unique = true)
    private String email ;

    @Column(unique = true)
    private String code;

    @JsonProperty("pass_word") 
    private String passWord ;

    private Boolean is_active;

    private String profil_img;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "chef" , fetch = FetchType.LAZY)
    private List<Projet> projets;

    @OneToMany(mappedBy = "encadrant" , fetch =  FetchType.LAZY)
    @JsonIgnore
    private List<Modules> modules;

    @OneToMany(mappedBy = "user" , fetch =  FetchType.LAZY)
    @JsonIgnore
    private List<Token> tokens;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return role.getAuthorities();
    }
    @Override
    public String getPassword() {
        return passWord;
    }
    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public boolean isAccountNonExpired() {
      return true;
    }
  
    @Override
    public boolean isAccountNonLocked() {
      return true;
    }
  
    @Override
    public boolean isCredentialsNonExpired() {
      return true;
    }
  
    @Override
    public boolean isEnabled() {
      return true;
    }
    
}
