package bouda.med.company.services.Chapitre;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.chapitre.AjouterChapitreDto;
import bouda.med.company.DTO.chapitre.ChapitreResDto;
import bouda.med.company.dao.ChapitreDao;
import bouda.med.company.exception.EntityNotFoundException;
import bouda.med.company.models.Chapitre;
import bouda.med.company.models.Modules;
import bouda.med.company.models.SousModules;

@Service
public class ChapitreSerImpl implements ChapitreService{

    @Autowired
    private ChapitreDao chapitreDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void ajouter(AjouterChapitreDto Req, SousModules sousModule) {

        Chapitre chapitre = modelMapper.map(Req,Chapitre.class);

        chapitre.setSousModules(sousModule);

        chapitre.setId(this.generateChapitreId());

        chapitreDao.save(chapitre);
        
    }

    
    

    @Override
    public Chapitre findById(String id) {
        return chapitreDao.findById(id).orElseThrow(()-> new EntityNotFoundException("Aucun chapitre trouve"));
    }

    @Override
    public List<Chapitre> findBySousModule(SousModules sousModules) {
        return chapitreDao.findBySousModules(sousModules);
    }




    @Override
    public String generateChapitreId() {
       Optional<Chapitre> lastIteams = chapitreDao.findTopByOrderByIdDesc();
        int newIdNumber = 1; 

        if (lastIteams.isPresent()) {
            String lastId = lastIteams.get().getId();
            String numberPart = lastId.substring(3); 
            System.out.println(numberPart);
            newIdNumber = Integer.parseInt(numberPart) + 1;
            System.out.println(newIdNumber); // Incrémente
        }

        return String.format("CH%03d", newIdNumber); // Formate en "EN00"
    }
    
}
