package bouda.med.company.services.DemandeEnService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.DemandeEn.AjouterDemandeEnReqDto;
import bouda.med.company.dao.DemnadeEnDao;
import bouda.med.company.models.DemandeEn;
import bouda.med.company.models.Modules;
import bouda.med.company.models.Renion;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DemandeEnServiceImpl implements DemandeEnService{

    @Autowired
    private DemnadeEnDao demnadeEnDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void ajouter(AjouterDemandeEnReqDto req, Modules module) {
        DemandeEn demandeEn = modelMapper.map(req,DemandeEn.class);

        demandeEn.setId(generateId());
        demandeEn.setAcceptation(false);
        demandeEn.setDate_demande(new Date());
        demandeEn.setDate_acceptation(null);
        demandeEn.setDemandedModel(module);

        demnadeEnDao.save(demandeEn);


        
    }

    @Override
    public List<DemandeEn> findByRenion(Renion renion) {
        return demnadeEnDao.findByDemandeRenion(renion);
    }

    @Override
    public List<DemandeEn> findByModule(Modules module) {
        return demnadeEnDao.findByDemandedModel(module);
    }

    @Override
    public List<DemandeEn> findByStatus(Boolean status) {
        return demnadeEnDao.findByAcceptation(false);
    }

    @Override
    public String generateId() {
        Optional<DemandeEn> lastIteams = demnadeEnDao.findTopByOrderByIdDesc();
        int newIdNumber = 1; 

        if (lastIteams.isPresent()) {
            String lastId = lastIteams.get().getId();
            String numberPart = lastId.substring(2); 
            newIdNumber = Integer.parseInt(numberPart) + 1; // Incrémente
        }

        return String.format("DM%03d", newIdNumber); // Formate en "EN00"
    }

    
    
}
