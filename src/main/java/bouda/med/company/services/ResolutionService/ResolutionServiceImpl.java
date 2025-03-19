package bouda.med.company.services.ResolutionService;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.ResolutionRenion.AjouterResolutionRenionReqDto;
import bouda.med.company.dao.ResolutionDao;
import bouda.med.company.models.Modules;
import bouda.med.company.models.Objectif;
import bouda.med.company.models.Resolution;


@Service
public class ResolutionServiceImpl implements ResolutionService{


    @Autowired
    private ResolutionDao resolutionDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void ajouter(AjouterResolutionRenionReqDto req, Objectif objectif) {
        Resolution resolution = modelMapper.map(req,Resolution.class);

        resolution.setId(generateId());
        resolution.setObjectif(objectif);

        resolutionDao.save(resolution);

        
    }

    @Override
    public List<Resolution> findByObjectif(Objectif objectif) {
        return resolutionDao.findByObjectif(objectif);
    }

    @Override
    public String generateId() {
        Optional<Resolution> lastIteams = resolutionDao.findTopByOrderByIdDesc();
        int newIdNumber = 1; 

        if (lastIteams.isPresent()) {
            String lastId = lastIteams.get().getId();
            String numberPart = lastId.substring(2); 
            newIdNumber = Integer.parseInt(numberPart) + 1; // Incrémente
        }

        return String.format("RE%03d", newIdNumber); // Formate en "EN00"
    }





    
}
