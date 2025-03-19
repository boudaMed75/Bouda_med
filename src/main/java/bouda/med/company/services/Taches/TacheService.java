package bouda.med.company.services.Taches;

import java.util.List;

import bouda.med.company.DTO.tache.AjouterTacheDto;
import bouda.med.company.models.Chapitre;
import bouda.med.company.models.Modules;
import bouda.med.company.models.Projet;
import bouda.med.company.models.Taches;
import bouda.med.company.user.User;

public interface TacheService {


    public void ajouter(AjouterTacheDto Req,Chapitre chapitre);

    public void addTaches();

    public Taches findById(String id);

    public List<Taches> findByChapitre(Chapitre user);

    public String generateModuleId();

    
}
