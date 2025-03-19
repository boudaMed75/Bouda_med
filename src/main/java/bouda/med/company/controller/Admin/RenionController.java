package bouda.med.company.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bouda.med.company.DTO.Renion.AjouterRenionReqDto;
import bouda.med.company.models.Renion;
import bouda.med.company.user.adminService.RenionAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1/admin/renion")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor


public class RenionController {

    @Autowired
    private RenionAdminService renionAdminService;


    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterRenion(@RequestBody AjouterRenionReqDto req) {
        renionAdminService.ajouterRenion(req);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-by-project")
    public List<Renion> getByProject(@RequestParam String id) {
       return renionAdminService.findRenionByProjet(id);
    }
    
    
    
}
