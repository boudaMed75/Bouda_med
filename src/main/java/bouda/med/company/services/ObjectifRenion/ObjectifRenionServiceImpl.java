package bouda.med.company.services.ObjectifRenion;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.ObjectifRenion.AjouterObjectifRenionReqDto;
import bouda.med.company.dao.ObjectifRenionDao;
import bouda.med.company.exception.EntityNotFoundException;
import bouda.med.company.models.Modules;
import bouda.med.company.models.Objectif;
import bouda.med.company.models.Renion;

@Service
public class ObjectifRenionServiceImpl implements ObjectifRenionService {

    @Autowired
    private ObjectifRenionDao objectifRenionDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void ajouter(AjouterObjectifRenionReqDto req, Renion renion) {

        Objectif objectif = modelMapper.map(req, Objectif.class);

        objectif.setId(generateId());
        objectif.setObjRenion(renion);

        objectifRenionDao.save(objectif);
        
    }

    @Override
    public Objectif findById(String id) {
        return objectifRenionDao.findById(id).orElseThrow(()-> new EntityNotFoundException("Objectif not found"));
    }

    @Override
    public List<Objectif> findByRenion(Renion renion) {
        return objectifRenionDao.findByObjRenion(renion);
    }

    @Override
    public String generateId() {
        Optional<Objectif> lastIteams = objectifRenionDao.findTopByOrderByIdDesc();
        int newIdNumber = 1; 

        if (lastIteams.isPresent()) {
            String lastId = lastIteams.get().getId();
            String numberPart = lastId.substring(2); 
            newIdNumber = Integer.parseInt(numberPart) + 1; // Incrémente
        }

        return String.format("OBJF%03d", newIdNumber); // Formate en "EN00"
    }


    
}
