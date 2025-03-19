package bouda.med.company.services.SousModule;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.SousModule.AjouterSousModuleDto;
import bouda.med.company.DTO.SousModule.SousModulesResDto;
import bouda.med.company.DTO.SousModule.SousModulesSimpleResDto;
import bouda.med.company.dao.SousModuleDao;
import bouda.med.company.exception.EntityNotFoundException;
import bouda.med.company.models.Modules;
import bouda.med.company.models.SousModules;

@Service
public class SousModuleSerImpl implements SousModuleService{

    @Autowired
    private SousModuleDao sousModuleDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void ajouter(AjouterSousModuleDto req, Modules modules) {
        SousModules sousModel = modelMapper.map(req, SousModules.class);
        sousModel.setModule(modules);
        sousModel.setId(generateSousModuleId());
        sousModuleDao.save(sousModel);
    }

    @Override
    public SousModules findById(String id) {
        SousModules sousModules = sousModuleDao.findById(id).orElseThrow(()-> new EntityNotFoundException("sous Module Not Found"));

        return sousModules;
    }

    @Override
    public List<SousModules> findByModule(Modules module) {
        return sousModuleDao.findByModule(module);
    }

    @Override
    public String generateSousModuleId() {
        Optional<SousModules> lastIteams = sousModuleDao.findTopByOrderByIdDesc();
        int newIdNumber = 1; 

        if (lastIteams.isPresent()) {
            String lastId = lastIteams.get().getId();
            String numberPart = lastId.substring(2); 
            newIdNumber = Integer.parseInt(numberPart) + 1; // Incrémente
        }

        return String.format("SO%02d", newIdNumber); // Formate en "EN00"
    }

    
}
