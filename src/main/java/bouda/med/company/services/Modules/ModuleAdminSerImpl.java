package bouda.med.company.services.Modules;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.modules.AjouterModuleDto;
import bouda.med.company.DTO.modules.ModuleResSimple;
import bouda.med.company.DTO.modules.ModulesSousModulesResDto;
import bouda.med.company.dao.ModuleDao;
import bouda.med.company.exception.EntityNotFoundException;
import bouda.med.company.models.Modules;
import bouda.med.company.models.Projet;
import bouda.med.company.models.Renion;
import bouda.med.company.user.User;

@Service
public class ModuleAdminSerImpl implements ModuleAdmin{

    @Autowired
    private ModuleDao moduleDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void ajouter(AjouterModuleDto req, Projet pro, User user) {

        // modelMapper.typeMap(AjouterModuleDto.class, Modules.class).addMappings(mapper -> {
        //     mapper.skip(Modules::setId);  // Skip 'id' field during mapping
        // });

        Modules mo = modelMapper.map(req,Modules.class);

        mo.setProjet(pro);
        mo.setEncadrant(user);
        mo.setId(this.generateModuleId());

        moduleDao.save(mo);
       
    }

   
    @Override
    public Modules findById(String id) {
       Modules module = moduleDao.findById(id).orElseThrow(()-> new EntityNotFoundException("Module Not Found"));

       return module;
    }

    @Override
    public String generateModuleId() {
        Optional<Modules> lastIteams = moduleDao.findTopByOrderByIdDesc();
        int newIdNumber = 1; 

        if (lastIteams.isPresent()) {
            String lastId = lastIteams.get().getId();
            String numberPart = lastId.substring(2); 
            newIdNumber = Integer.parseInt(numberPart) + 1; // Incrémente
        }

        return String.format("MO%02d", newIdNumber); // Formate en "EN00"
    }

    @Override
    public List<Modules> findByUser(User user) {
       return moduleDao.findByEncadrant(user);
    }

    @Override
    public List<Modules> findByProjet(Projet projet) {
       return moduleDao.findByProjet(projet);
    }


    @Override
    public List<Modules> findByProjectAndUser(Projet projet, User user) {
        return moduleDao.findByProjetAndEncadrant(projet, user);
    }
    
}
