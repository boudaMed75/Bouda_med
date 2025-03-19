package bouda.med.company.services.ObjectifRenion;

import java.util.List;

import bouda.med.company.DTO.ObjectifRenion.AjouterObjectifRenionReqDto;
import bouda.med.company.models.Objectif;
import bouda.med.company.models.Renion;

public interface ObjectifRenionService {
    void ajouter(AjouterObjectifRenionReqDto req,Renion renion);
    Objectif findById(String id);
    List<Objectif> findByRenion(Renion renion);
    String generateId();
}
