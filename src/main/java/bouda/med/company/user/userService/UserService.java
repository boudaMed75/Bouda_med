package bouda.med.company.user.userService;

import java.io.IOException;
import java.util.List;

import bouda.med.company.DTO.utilisateur.AjouterReq;
import bouda.med.company.DTO.utilisateur.AjouterReqV1;
import bouda.med.company.DTO.utilisateur.UtilisateurRes;
import bouda.med.company.user.User;

public interface UserService {
    

    public User findById(String id);

    public List<UtilisateurRes> getAllUser();

    public List<UtilisateurRes> getUserByModule();

    public String generateModuleId();

    public void ajouter(AjouterReq req) throws IllegalStateException, IOException ;

    public void ajouter_v1(AjouterReqV1 reqV1);

    
    

}

