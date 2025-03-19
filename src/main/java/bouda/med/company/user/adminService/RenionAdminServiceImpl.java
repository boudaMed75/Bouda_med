package bouda.med.company.user.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.Renion.AjouterRenionReqDto;
import bouda.med.company.models.Projet;
import bouda.med.company.models.Renion;
import bouda.med.company.services.Projet.ProjetService;
import bouda.med.company.services.Renion.RenionService;



@Service
public class RenionAdminServiceImpl implements RenionAdminService{

    @Autowired
    private ProjetService projetService;
    @Autowired
    private RenionService renionService;


    @Override
    public void ajouterRenion(AjouterRenionReqDto req) {
        renionService.ajouter(req, projetService.findById(req.getProjet()));
    }


    @Override
    public List<Renion> findRenionByProjet(String id) {
        return renionService.findByProjet(projetService.findById(id));
    }

    
    
    
}
