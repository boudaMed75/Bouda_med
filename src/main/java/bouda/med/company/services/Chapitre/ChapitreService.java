package bouda.med.company.services.Chapitre;

import java.util.List;

import bouda.med.company.DTO.chapitre.AjouterChapitreDto;
import bouda.med.company.DTO.chapitre.ChapitreResDto;
import bouda.med.company.models.Chapitre;
import bouda.med.company.models.SousModules;

public interface ChapitreService {
    
    public void ajouter(AjouterChapitreDto Req,SousModules sousModule);

    public Chapitre findById(String id);

    public List<Chapitre> findBySousModule(SousModules sousModules);

    public String generateChapitreId();
}
