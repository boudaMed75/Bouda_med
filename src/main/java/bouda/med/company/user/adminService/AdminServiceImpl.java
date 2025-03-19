package bouda.med.company.user.adminService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
import bouda.med.company.dao.TachesDao;
import bouda.med.company.models.Chapitre;
import bouda.med.company.models.Modules;
import bouda.med.company.models.Projet;
import bouda.med.company.models.SousModules;
import bouda.med.company.services.Chapitre.ChapitreSerImpl;
import bouda.med.company.services.File.FileProfileService;
import bouda.med.company.services.Modules.ModuleAdminSerImpl;
import bouda.med.company.services.Projet.ProjetImpl;
import bouda.med.company.services.SousModule.SousModuleSerImpl;
import bouda.med.company.services.Taches.TacheSerImpl;
import bouda.med.company.shared.CodeGenerator;
import bouda.med.company.user.User;
import bouda.med.company.user.UserDao;
import bouda.med.company.user.userService.UserServiceImpl;
import jakarta.validation.Valid;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ProjetImpl projetImpl;

    @Autowired
    private ModuleAdminSerImpl moduleAdminSerImpl;

    @Autowired
    private SousModuleSerImpl sousModuleSerImpl;

    @Autowired
    private ChapitreSerImpl chapitreSerImpl;

    @Autowired
    private TacheSerImpl tacheSerImpl;

    @Autowired
    private FileProfileService profileSer;

    @Autowired
    private CodeGenerator codeGenerator;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;

    @Override
    public void ajouter(AjouterProjetDto req) {

        projetImpl.ajouter(req, userService.findById(req.getUser_id()));

    }

    // @Override
    // public void ajouter_module(AjouterModuleDto req) {

    //     // moduleAdminSerImpl.ajouter(req,projetImpl.findById(req.getId_pro()), userService.findById(req.getId_user()));
        
    // }

    // @Override
    // public void ajouter_sous_module(AjouterSousModuleDto req) {

    //     Modules module = moduleAdminSerImpl.findById(req.getModule_id());

    //     sousModuleSerImpl.ajouter(req, module);

    // }

    // @Override
    // public void ajouter_chapitre(AjouterChapitreDto req) {
    //     SousModules sousModule = sousModuleSerImpl.findById(req.getId_sous_mo());
    //     chapitreSerImpl.ajouter(req, sousModule);
    // }

    // @Override
    // public void ajouter_tache(AjouterTacheDto req) {
    //     Chapitre chapitre = chapitreSerImpl.findById(req.getId_chapitre());

    //     tacheSerImpl.ajouter(req, chapitre);
    // }

    @Override
    public void ajouter_encadrant(@Valid AjouterReq req) throws IllegalStateException, IOException {

        String code_en = codeGenerator.generateCodeUnique(8);

        String file_name = req.getEmail() + "_" + code_en;

        profileSer.saveFile(req.getImgs(), file_name);

        User user = modelMapper.map(req,User.class);

        user.setProfil_img(file_name);
        user.setPassWord(passwordEncoder.encode(req.getPassWord()));
        userDao.save(user);
        
    }



    
    @Override
    public List<UtilisateurRes> getAllUser() {
        return userService.getAllUser();

    }

    @Override
    public List<ProjectResDto> getAllProject() {
        return projetImpl.getAll();
    }

    @Override
    public List<ProjectResDto> getProjectByYears(int years) {
        return projetImpl.getByYears(years);
    }

    // SousModules

    @Override
    public void ajouter_module(AjouterModuleDto req) {
       moduleAdminSerImpl.ajouter(req, projetImpl.findById(req.getPro()),userService.findById(req.getUser()));
    }

    @Override
    public Modules findById(String id) {
       Modules module =  moduleAdminSerImpl.findById(id);

       return module;
    }

    @Override
    public List<ModuleResSimple> findByUser(String user_id) {
        return moduleAdminSerImpl.findByUser(userService.findById(user_id)).stream().map(el -> modelMapper.map(el,ModuleResSimple.class))
        .collect(Collectors.toList());
    }

    @Override
    public List<ModuleResSimple> findByProject(String pro_id) {
        return moduleAdminSerImpl.findByProjet(projetImpl.findById(pro_id)).stream().map(el -> modelMapper.map(el,ModuleResSimple.class))
        .collect(Collectors.toList());
    }

    @Override
    public void ajouter_sous_module(AjouterSousModuleDto req) {
        sousModuleSerImpl.ajouter(req, moduleAdminSerImpl.findById(req.getModule()));
    }

    @Override
    public SousModulesSimpleResDto getSousModuleById(String id) {
        SousModules sousodule = sousModuleSerImpl.findById(id);

        return modelMapper.map(sousodule,SousModulesSimpleResDto.class);
    }
        

    @Override
    public List<SousModulesResDto> getSousModulesByModule(String id) {
        List<SousModules> sousModules = sousModuleSerImpl.findByModule(moduleAdminSerImpl.findById(id));

       
        return sousModuleSerImpl.findByModule(moduleAdminSerImpl.findById(id)).stream().map(el -> modelMapper.map(el,SousModulesResDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public List<SousModules> getSousModuleByModule(String id) {
        return sousModuleSerImpl.findByModule(moduleAdminSerImpl.findById(id));
    }

    @Override
    public void ajouter_chapitre(AjouterChapitreDto req) {
        chapitreSerImpl.ajouter(req,sousModuleSerImpl.findById(req.getSous_mo()));
    }

    @Override
    public ChapitreResSimpleDto getChapitreById(String id) {
        return modelMapper.map(chapitreSerImpl.findById(id),ChapitreResSimpleDto.class);
    }

    @Override
    public List<Chapitre> getChapitreBySousModule(String id) {
        return chapitreSerImpl.findBySousModule(sousModuleSerImpl.findById(id));
    }

    @Override
    public Projet getProjetById(String id) {
        return projetImpl.findById(id);
    }

    @Override
    public void ajouter_encadrant_v1(AjouterReqV1 req) {
       userService.ajouter_v1(req);
    }

    @Override
    public void ajouter_tache(AjouterTacheDto req) {
        tacheSerImpl.ajouter(req, chapitreSerImpl.findById(req.getChapitre()));
    }

    
    
}
