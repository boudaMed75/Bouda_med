package bouda.med.company.user.userService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.utilisateur.AjouterReq;
import bouda.med.company.DTO.utilisateur.AjouterReqV1;
import bouda.med.company.DTO.utilisateur.UtilisateurRes;
import bouda.med.company.exception.EntityNotFoundException;
import bouda.med.company.services.File.FileProfileService;
import bouda.med.company.shared.CodeGenerator;
import bouda.med.company.user.User;
import bouda.med.company.user.UserDao;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FileProfileService fileProfileService;

    @Autowired
    private CodeGenerator codeGenerator;

    private PasswordEncoder passwordEncoder;

    @Override
    public User findById(String id) {
        return userDao.findById(id).orElseThrow(()-> new EntityNotFoundException("User not Found"));
    }

    @Override
    public List<UtilisateurRes> getAllUser() {
        return userDao.findAll().stream().map(el -> modelMapper.map(el, UtilisateurRes.class))
        .collect(Collectors.toList());
    }

    @Override
    public List<UtilisateurRes> getUserByModule() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserByModule'");
    }

    @Override
    public String generateModuleId() {
        
        Optional<User> lastUser = userDao.findTopByOrderByIdDesc();
        int newIdNumber = 1; 

        if (lastUser.isPresent()) {
            String lastId = lastUser.get().getId();
            String numberPart = lastId.substring(2); 
            newIdNumber = Integer.parseInt(numberPart) + 1; // Incrémente
        }

        return String.format("EN%02d", newIdNumber); // Formate en "EN00"
    }

    @Override
    public void ajouter(AjouterReq req) throws IllegalStateException, IOException {

        String code_en = codeGenerator.generateCodeUnique(8);

        String file_name = req.getEmail() + "_" + code_en;

        fileProfileService.saveFile(req.getImgs(), file_name);


        User user = modelMapper.map(req,User.class);

        user.setProfil_img(file_name);
        user.setPassWord(passwordEncoder.encode(req.getPassWord()));
        user.setId(this.generateModuleId());
        userDao.save(user);

    }

    @Override
    public void ajouter_v1(AjouterReqV1 reqV1) {
        String code_en = codeGenerator.generateCodeUnique(8);

        User user = modelMapper.map(reqV1,User.class);

        user.setCode(code_en);
        user.setId(this.generateModuleId());

        userDao.save(user);
    }

    


    

    

    
}
