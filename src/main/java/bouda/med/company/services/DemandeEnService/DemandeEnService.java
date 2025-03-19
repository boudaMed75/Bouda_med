package bouda.med.company.services.DemandeEnService;

import java.util.List;

import bouda.med.company.DTO.DemandeEn.AjouterDemandeEnReqDto;
import bouda.med.company.models.DemandeEn;
import bouda.med.company.models.Modules;
import bouda.med.company.models.Renion;

public interface DemandeEnService {

    void ajouter(AjouterDemandeEnReqDto req,Modules module);
    List<DemandeEn> findByRenion(Renion renion);
    List<DemandeEn> findByModule(Modules module);
    List<DemandeEn> findByStatus(Boolean status);

    String generateId();

    
}
