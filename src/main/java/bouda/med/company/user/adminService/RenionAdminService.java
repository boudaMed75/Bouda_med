package bouda.med.company.user.adminService;

import java.util.List;

import bouda.med.company.DTO.Renion.AjouterRenionReqDto;
import bouda.med.company.models.Projet;
import bouda.med.company.models.Renion;

public interface RenionAdminService {
    void ajouterRenion(AjouterRenionReqDto req);
    List<Renion> findRenionByProjet(String id);

}
