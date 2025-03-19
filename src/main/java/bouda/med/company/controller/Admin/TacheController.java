package bouda.med.company.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bouda.med.company.DTO.tache.AjouterTacheDto;
import bouda.med.company.user.adminService.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/admin/taches")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor

public class TacheController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouter (@RequestBody AjouterTacheDto req) {
        adminService.ajouter_tache(req);

        return ResponseEntity.ok().build();
    }
    
    
}
