package bouda.med.company.controller.Admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bouda.med.company.DTO.utilisateur.AjouterReq;
import bouda.med.company.DTO.utilisateur.AjouterReqV1;
import bouda.med.company.DTO.utilisateur.UtilisateurRes;
import bouda.med.company.user.adminService.AdminServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1/admin/encadrants")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor

public class UserController {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @PostMapping("/ajouter_en")
    
    public void ajouter(@ModelAttribute AjouterReq req) throws IllegalStateException, IOException{
        adminServiceImpl.ajouter_encadrant(req);
    }


    @PostMapping("/ajouter_v1")
    public void ajouterV1(@RequestBody AjouterReqV1 req) {
        adminServiceImpl.ajouter_encadrant_v1(req);
    }
    

    @GetMapping("/listes_en")
    public List<UtilisateurRes> getAllUser(){
        return adminServiceImpl.getAllUser();
    }

    


    
}
