package bouda.med.company.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bouda.med.company.DTO.modules.AjouterModuleDto;
import bouda.med.company.DTO.modules.ModuleResSimple;
import bouda.med.company.DTO.modules.ModulesSousModulesResDto;
import bouda.med.company.DTO.projet.AjouterProjetDto;
import bouda.med.company.DTO.projet.ProjectResDto;
import bouda.med.company.models.Modules;
import bouda.med.company.user.adminService.AdminService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin/modules")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor

public class ModulesController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouter(@RequestBody AjouterModuleDto req) {
        adminService.ajouter_module(req);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findModule")
    public ResponseEntity<Modules> findModules(@RequestParam String id){
        return ResponseEntity.ok(adminService.findById(id));
    }

    @GetMapping("/getModulesByUser")
    public ResponseEntity<List<ModuleResSimple>> getModulesByUser(@RequestParam String id){
        return ResponseEntity.ok(adminService.findByUser(id));
    }

    @GetMapping("/getModulesByProject")
    public ResponseEntity<List<ModuleResSimple>> getModulesByPro(@RequestParam String id){
        return ResponseEntity.ok(adminService.findByProject(id));
    }


    
}
