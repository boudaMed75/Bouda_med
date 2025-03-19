package bouda.med.company.services.Renion;

import java.util.List;

import bouda.med.company.DTO.Renion.AjouterRenionReqDto;
import bouda.med.company.models.Projet;
import bouda.med.company.models.Renion;

public interface RenionService {
    void ajouter(AjouterRenionReqDto req,Projet projet);
    Renion findById(String id);
    List<Renion> findByProjet(Projet projet);
    

    String generateId();
}
