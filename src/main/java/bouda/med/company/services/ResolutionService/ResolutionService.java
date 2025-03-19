package bouda.med.company.services.ResolutionService;

import java.util.List;

import bouda.med.company.DTO.ResolutionRenion.AjouterResolutionRenionReqDto;
import bouda.med.company.models.Objectif;
import bouda.med.company.models.Resolution;

public interface ResolutionService {
    void ajouter(AjouterResolutionRenionReqDto req,Objectif objectif);

    List<Resolution> findByObjectif(Objectif objectif);

    String generateId();

}
