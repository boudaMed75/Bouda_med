package bouda.med.company.services.Renion;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.Renion.AjouterRenionReqDto;
import bouda.med.company.dao.RenionDao;
import bouda.med.company.exception.EntityNotFoundException;
import bouda.med.company.models.Modules;
import bouda.med.company.models.Projet;
import bouda.med.company.models.Renion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Service

public class RenionServiceImpl implements RenionService {

    @Autowired
    private RenionDao renionDao ;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void ajouter(AjouterRenionReqDto req, Projet projet) {

        Renion renion = modelMapper.map(req,Renion.class);

        renion.setId(generateId());
        renion.setProjetRenion(projet);

        renionDao.save(renion);
        
    }

    @Override
    public Renion findById(String id) {
        return renionDao.findById(id).orElseThrow(()->new EntityNotFoundException("Renion non yrouver"));
    }

    @Override
    public List<Renion> findByProjet(Projet projet) {
        return renionDao.findByProjetRenion(projet);
    }

    @Override
    public String generateId() {
        Optional<Renion> lastIteams = renionDao.findTopByOrderByIdDesc();
        int newIdNumber = 1; 

        if (lastIteams.isPresent()) {
            String lastId = lastIteams.get().getId();
            String numberPart = lastId.substring(2); 
            newIdNumber = Integer.parseInt(numberPart) + 1; // Incrémente
        }

        return String.format("RE%02d", newIdNumber); // Formate en "EN00"
    }
    
    
}
