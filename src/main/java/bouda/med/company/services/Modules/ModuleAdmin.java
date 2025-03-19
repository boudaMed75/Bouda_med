package bouda.med.company.services.Modules;

import java.util.List;

import bouda.med.company.DTO.modules.AjouterModuleDto;
import bouda.med.company.DTO.modules.ModuleResSimple;
import bouda.med.company.DTO.modules.ModulesFullResDto;
import bouda.med.company.DTO.modules.ModulesSousModulesResDto;
import bouda.med.company.models.Modules;
import bouda.med.company.models.Projet;
import bouda.med.company.user.User;

public interface ModuleAdmin {

    public void ajouter(AjouterModuleDto req,Projet pro,User user);

    public Modules findById(String id);

    public List<Modules> findByUser(User user);

    public List<Modules> findByProjet(Projet projet);

    public List<Modules> findByProjectAndUser(Projet projet,User user);


    public String generateModuleId();

    
}
