package bouda.med.company.user.EmployeService;

import java.util.List;

import bouda.med.company.models.Modules;
import bouda.med.company.models.Projet;

public interface EmployeService {

    String getUserID_fromToken();
    
    List<Modules> getModulesDansProjetActuelle();
    List<Modules> getModulesParProjet(String id);
    List<Modules> getAllModules();

}
