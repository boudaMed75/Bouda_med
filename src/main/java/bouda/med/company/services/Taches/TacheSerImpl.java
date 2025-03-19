package bouda.med.company.services.Taches;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.tache.AjouterTacheDto;
import bouda.med.company.dao.ChapitreDao;
import bouda.med.company.dao.SousModuleDao;
import bouda.med.company.dao.TachesDao;
import bouda.med.company.exception.EntityNotFoundException;
import bouda.med.company.models.Chapitre;
import bouda.med.company.models.SousModules;
import bouda.med.company.models.Taches;

@Service
public class TacheSerImpl implements TacheService{

    @Autowired
    private TachesDao tachesDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SousModuleDao sousModuleDao;

    @Autowired
    private ChapitreDao chapitreDao;

    @Override
    public void ajouter(AjouterTacheDto Req, Chapitre chapitre) {
        Taches taches = modelMapper.map(Req,Taches.class);
        taches.setCompleted(false);
        taches.setChapitre(chapitre);
        taches.setId(this.generateModuleId());
        tachesDao.save(taches);
    }

    @Override
    public Taches findById(String id) {
        return tachesDao.findById(id).orElseThrow(()->new EntityNotFoundException("aucun taches"));
    }

    @Override
    public List<Taches> findByChapitre(Chapitre user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByChapitre'");
    }

    @Override
    public String generateModuleId() {
       
        Optional<Taches> lastIteams = tachesDao.findTopByOrderByIdDesc();
        int newIdNumber = 1; 

        if (lastIteams.isPresent()) {
            String lastId = lastIteams.get().getId();
            String numberPart = lastId.substring(2); 
            System.out.println(numberPart);
            newIdNumber = Integer.parseInt(numberPart) + 1; // Incrémente
            System.out.println(newIdNumber);
        }
        
        return String.format("TA%05d", newIdNumber); // Formate en "EN00"
    
    }

    @Override
    public void addTaches() {
        List<SousModules> sousModules = sousModuleDao.findAll();

        for (SousModules element : sousModules) {

            Chapitre ch = new Chapitre();

            System.out.println(ch.getName());
            
            ch.setId(element.getId());
            ch.setName(element.getName());
            ch.setDescription(element.getDescription());
            ch.setSousModules(element);

            chapitreDao.save(ch);
            
        }
    }

 
    
}
