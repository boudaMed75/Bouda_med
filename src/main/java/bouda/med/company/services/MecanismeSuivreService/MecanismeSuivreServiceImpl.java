package bouda.med.company.services.MecanismeSuivreService;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.MecanismeSuivre.AjouterMecanismeSuivreReqDto;
import bouda.med.company.dao.MecanismeSuivreDao;
import bouda.med.company.models.MecanismSuivre;
import bouda.med.company.models.Modules;
import bouda.med.company.models.ResultatRenion;

@Service
public class MecanismeSuivreServiceImpl implements MecanismeSuivreService{

    @Autowired
    private MecanismeSuivreDao mecanismeSuivreDao;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void ajouter(AjouterMecanismeSuivreReqDto req, ResultatRenion resultatRenion) {
        MecanismSuivre mecanismSuivre = modelMapper.map(req, MecanismSuivre.class);

        mecanismSuivre.setId(generateId());
        mecanismSuivre.setDate_finish(null);
        mecanismSuivre.setIs_faied(false);
        mecanismSuivre.setIs_faied(false);
        mecanismSuivre.setIs_finished(false);
        mecanismSuivre.setResult(resultatRenion);

        mecanismeSuivreDao.save(mecanismSuivre);
    }
    @Override
    public List<MecanismSuivre> findByResult(ResultatRenion resultatRenion) {
        return mecanismeSuivreDao.findByResult(resultatRenion);
    }
    @Override
    public String generateId() {
        Optional<MecanismSuivre> lastIteams = mecanismeSuivreDao.findTopByOrderByIdDesc();
        int newIdNumber = 1; 

        if (lastIteams.isPresent()) {
            String lastId = lastIteams.get().getId();
            String numberPart = lastId.substring(2); 
            newIdNumber = Integer.parseInt(numberPart) + 1; // Incrémente
        }

        return String.format("MAS%05d", newIdNumber); // Formate en "EN00"
    }
    
}
