package bouda.med.company.controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bouda.med.company.DTO.modules.ModuleResSimple;
import bouda.med.company.models.Modules;
import bouda.med.company.user.EmployeService.EmployeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user/modules")
@PreAuthorize("hasRole('USER')")
@RequiredArgsConstructor

public class ModuleUserController {

    @Autowired
    private EmployeService employeService;


    @GetMapping("/getModuleActuelle")
    public ResponseEntity<List<Modules>> getModulesActuelle(){
        return ResponseEntity.ok(employeService.getModulesDansProjetActuelle());
    }

    @GetMapping("/getAllModules")
    public ResponseEntity<List<Modules>> getAllModules(){
        return ResponseEntity.ok(employeService.getAllModules());
    }

    @GetMapping("/getModuleByProjects")
    public ResponseEntity<List<Modules>> getAllModulesByProjects(@RequestParam String id){
        return ResponseEntity.ok(employeService.getModulesParProjet(id));
    }

    
}
