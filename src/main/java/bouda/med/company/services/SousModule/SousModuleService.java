package bouda.med.company.services.SousModule;

import java.util.List;

import bouda.med.company.DTO.SousModule.AjouterSousModuleDto;
import bouda.med.company.DTO.SousModule.SousModulesResDto;
import bouda.med.company.DTO.SousModule.SousModulesSimpleResDto;
import bouda.med.company.models.Modules;
import bouda.med.company.models.SousModules;

public interface SousModuleService {

    public void ajouter(AjouterSousModuleDto req,Modules modules);

    public SousModules findById(String id);

    public List<SousModules> findByModule(Modules module);


    public String generateSousModuleId();
    
}
