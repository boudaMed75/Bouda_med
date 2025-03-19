package bouda.med.company.user.adminService;

import java.io.IOException;
import java.util.List;

import org.hibernate.sql.exec.spi.AbstractJdbcOperationQuery;

import bouda.med.company.DTO.SousModule.AjouterSousModuleDto;
import bouda.med.company.DTO.SousModule.SousModulesResDto;
import bouda.med.company.DTO.SousModule.SousModulesSimpleResDto;
import bouda.med.company.DTO.chapitre.AjouterChapitreDto;
import bouda.med.company.DTO.chapitre.ChapitreResSimpleDto;
import bouda.med.company.DTO.modules.AjouterModuleDto;
import bouda.med.company.DTO.modules.ModuleResSimple;
import bouda.med.company.DTO.modules.ModulesSousModulesResDto;
import bouda.med.company.DTO.projet.AjouterProjetDto;
import bouda.med.company.DTO.projet.ProjectResDto;
import bouda.med.company.DTO.tache.AjouterTacheDto;
import bouda.med.company.DTO.utilisateur.AjouterReq;
import bouda.med.company.DTO.utilisateur.AjouterReqV1;
import bouda.med.company.DTO.utilisateur.UtilisateurRes;
import bouda.med.company.models.Chapitre;
import bouda.med.company.models.Modules;
import bouda.med.company.models.Projet;
import bouda.med.company.models.SousModules;
import bouda.med.company.user.User;

public interface AdminService {

    // UTILISATEUR
    public void ajouter_encadrant(AjouterReq req) throws IllegalStateException, IOException;

    public void ajouter_encadrant_v1(AjouterReqV1 req);

    

    // PROJECT
    public void ajouter(AjouterProjetDto req);


    //  module 
    public void ajouter_module(AjouterModuleDto req);

    public Modules findById(String id);
    public List<ModuleResSimple> findByUser(String user_id);

    public List<ModuleResSimple> findByProject(String pro_id);


    // SOUS MODULES
    public void ajouter_sous_module(AjouterSousModuleDto req);
    public SousModulesSimpleResDto getSousModuleById(String id);
    public List<SousModulesResDto> getSousModulesByModule(String id);
    public List<SousModules> getSousModuleByModule(String id);
    

    // CHAPITRE
    public void ajouter_chapitre(AjouterChapitreDto req);
    public ChapitreResSimpleDto getChapitreById(String id);
    public List<Chapitre> getChapitreBySousModule(String id);

    // Tache
    public void ajouter_tache(AjouterTacheDto req);

    // USER
    public List<UtilisateurRes> getAllUser();

    // PROJET
    public List<ProjectResDto> getAllProject();
    public Projet getProjetById(String id);
    public List<ProjectResDto> getProjectByYears(int years);
}
