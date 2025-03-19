
package bouda.med.company.services.Projet;

import java.util.List;

import bouda.med.company.DTO.modules.AjouterModuleDto;
import bouda.med.company.DTO.projet.AjouterProjetDto;
import bouda.med.company.DTO.projet.ProjectResDto;
import bouda.med.company.models.Projet;
import bouda.med.company.user.User;

public interface ProjetService {
    
    public void ajouter(AjouterProjetDto req,User user);

    public Projet findById(String id);

    public Projet findByChef(User user);

    public Projet projetActuelle() ;

    public List<ProjectResDto> getAll();


    public List<ProjectResDto> getByYears(int year);

    public String generateProjectId();
}
