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

import bouda.med.company.DTO.SousModule.AjouterSousModuleDto;
import bouda.med.company.DTO.SousModule.SousModulesResDto;
import bouda.med.company.DTO.SousModule.SousModulesSimpleResDto;
import bouda.med.company.DTO.modules.AjouterModuleDto;
import bouda.med.company.DTO.modules.ModuleResSimple;
import bouda.med.company.models.SousModules;
import bouda.med.company.user.adminService.AdminService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin/sous_module")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class SousModuleController {

    @Autowired
    private AdminService adminService;

    
    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouter(@RequestBody AjouterSousModuleDto req) {
        adminService.ajouter_sous_module(req);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findById")
    public ResponseEntity<SousModulesSimpleResDto> findModules(@RequestParam String id){
        return ResponseEntity.ok(adminService.getSousModuleById(id));
    }

    @GetMapping("/getByModule")
    public ResponseEntity<List<SousModulesResDto>> getModulesByUser(@RequestParam String id){
        return ResponseEntity.ok(adminService.getSousModulesByModule(id));
    }

    @GetMapping("/getByModules")
    public ResponseEntity<List<SousModules>> getModulesByMo(@RequestParam String id){
        return ResponseEntity.ok(adminService.getSousModuleByModule(id));
    }

    
}
