package bouda.med.company.services.Projet;



import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.modules.AjouterModuleDto;
import bouda.med.company.DTO.projet.AjouterProjetDto;
import bouda.med.company.DTO.projet.ProjectResDto;
import bouda.med.company.dao.ProjetDao;
import bouda.med.company.exception.EntityNotFoundException;
import bouda.med.company.models.Projet;
import bouda.med.company.user.User;

@Service
public class ProjetImpl implements ProjetService {

    @Autowired
    private ProjetDao projetDao;

    @Autowired
    private ModelMapper modelMapper;

    

    
    @Override
    public List<ProjectResDto> getAll() {
        return projetDao.findAll().stream().map(el -> modelMapper.map(el, ProjectResDto.class))
                        .collect(Collectors.toList());
    }

    @Override
    public void ajouter(AjouterProjetDto req, User user) {
        Projet pro = modelMapper.map(req,Projet.class);
        pro.setProjectID(this.generateProjectId());
        pro.setChef(user);
        projetDao.save(pro);
    }

    // @Override
    // public void ajouter_module(AjouterModuleDto ajouterModuleDto, User user) {

        
        
    // }

    @Override
    public Projet findById(String id) {
        return projetDao.findById(id).orElseThrow(()->new EntityNotFoundException("Project Not Found"));
    }

    @Override
    public String generateProjectId() {
        Optional<Projet> lastIteams = projetDao.findTopByOrderByProjectIDDesc();
        int newIdNumber = 1; 

        if (lastIteams.isPresent()) {
            String lastId = lastIteams.get().getProjectID();
            String numberPart = lastId.substring(2); 
            newIdNumber = Integer.parseInt(numberPart) + 1; // Incrémente
        }

        return String.format("PO%02d", newIdNumber); // Formate en "EN00"
    }

    @Override
    public Projet findByChef(User user) {

        return projetDao.findByChef(user).orElseThrow(()->new EntityNotFoundException("Project Not Found"));
        
    }

    @Override
    public List<ProjectResDto> getByYears(int year) {
        return projetDao.findProjectsByYear(year).stream().map(el -> modelMapper.map(el,ProjectResDto.class))
                        .collect(Collectors.toList());
    }

    @Override
    public Projet projetActuelle() {
        LocalDateTime currentDate = LocalDateTime.now();
       
        return projetDao.findCurrentProjects(currentDate).orElseThrow(()-> new EntityNotFoundException("Aucun Projet Trouve"));
    }
    
}
