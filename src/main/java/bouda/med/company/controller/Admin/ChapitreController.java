package bouda.med.company.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bouda.med.company.DTO.chapitre.AjouterChapitreDto;
import bouda.med.company.services.Chapitre.ChapitreService;
import bouda.med.company.services.Taches.TacheService;
import bouda.med.company.user.adminService.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/admin/chapitre")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor


public class ChapitreController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouter(@RequestBody AjouterChapitreDto req) {
        adminService.ajouter_chapitre(req);
        return ResponseEntity.ok().build();
    }
    

   
    
    
}
