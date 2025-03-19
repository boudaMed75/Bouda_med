package bouda.med.company.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import bouda.med.company.DTO.projet.AjouterProjetDto;
import bouda.med.company.DTO.projet.ProjectResDto;
import bouda.med.company.models.Projet;
import bouda.med.company.services.Projet.ProjetImpl;
import bouda.med.company.user.adminService.AdminServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/admin/project")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class ProjetController {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouter(@RequestBody AjouterProjetDto req) {
        adminServiceImpl.ajouter(req);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllProjects")
    public ResponseEntity<List<ProjectResDto>> listeAllProject(){
        return ResponseEntity.ok(adminServiceImpl.getAllProject());
    }

    @GetMapping("/getProjectByYesrs")
    public ResponseEntity<List<ProjectResDto>> listeProjet(@RequestParam int year){
        return ResponseEntity.ok(adminServiceImpl.getProjectByYears(year));
    }

    @GetMapping("/getProjectById")
    public ResponseEntity<Projet> getById(@RequestParam String id){
        return ResponseEntity.ok(adminServiceImpl.getProjetById(id));
    }



    


    
    
    
    
}
