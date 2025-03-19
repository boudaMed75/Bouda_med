package bouda.med.company.user;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import bouda.med.company.DTO.utilisateur.AjouterReq;
import bouda.med.company.DTO.utilisateur.UtilisateurRes;


public interface UserService {

    void ajouter_utilisateur(AjouterReq ajouterReq);


    UtilisateurRes findById(String id);

    User findByid(String id);

    void delete(String id);

    UtilisateurRes update(UtilisateurRes utilisateurRes,String id);

    List<UtilisateurRes> findAll();

    public void saveUsersFromJson(MultipartFile file) throws IOException ;
    
    
}
