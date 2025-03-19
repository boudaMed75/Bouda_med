package bouda.med.company.services.MecanismeSuivreService;

import java.util.List;

import bouda.med.company.DTO.MecanismeSuivre.AjouterMecanismeSuivreReqDto;
import bouda.med.company.models.MecanismSuivre;
import bouda.med.company.models.ResultatRenion;

public interface MecanismeSuivreService {
    
    void ajouter(AjouterMecanismeSuivreReqDto req,ResultatRenion resultatRenion);
    List<MecanismSuivre> findByResult(ResultatRenion resultatRenion);


    String generateId();
}
