package bouda.med.company.user.EmployeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import bouda.med.company.models.Modules;
import bouda.med.company.models.Projet;
import bouda.med.company.services.Modules.ModuleAdmin;
import bouda.med.company.services.Projet.ProjetService;
import bouda.med.company.user.UserService;

@Service
public class EmployeServiceImp implements EmployeService {

    @Autowired
    private AuditorAware auditorAware;
    @Autowired
    private ModuleAdmin moduleAdmin;
    @Autowired
    private ProjetService projetService;
    @Autowired
    private UserService userService;


    @Override
    public String getUserID_fromToken() {
        Optional<Object> num = auditorAware.getCurrentAuditor();

        return num.get().toString();

        
    }



    @Override
    public List<Modules> getModulesDansProjetActuelle() {

        return moduleAdmin.findByProjectAndUser(projetService.projetActuelle(),userService.findByid(getUserID_fromToken()));
        
    }



    @Override
    public List<Modules> getModulesParProjet(String id) {
        return moduleAdmin.findByProjectAndUser(projetService.findById(id),userService.findByid(id)); 
    }



    @Override
    public List<Modules> getAllModules() {
        return moduleAdmin.findByUser(userService.findByid(getUserID_fromToken()));
    }

    
}
