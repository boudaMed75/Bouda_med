package bouda.med.company.user;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import bouda.med.company.DTO.utilisateur.AjouterReq;
import bouda.med.company.DTO.utilisateur.UtilisateurRes;
import bouda.med.company.exception.EntityAlreadyExistsException;
import bouda.med.company.exception.EntityNotFoundException;

@Service
public class UserServiceImplement implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;




    @Override
    public void ajouter_utilisateur(AjouterReq ajouterReq) {
        
        User user = userDao.findByEmail(ajouterReq.getEmail()).orElseThrow(()-> new EntityAlreadyExistsException("Email deja utiliser"));

        user.setPassWord(passwordEncoder.encode(ajouterReq.getPassWord()));

        userDao.save(user);

    }

    @Override
    public UtilisateurRes findById(String id) {
        User user = userDao.findById(id).orElseThrow(()->new EntityNotFoundException("Utilisateur not found"));

        return modelMapper.map(user, UtilisateurRes.class);

    }

    @Override
    public void delete(String id) {
        userDao.deleteById(id);
    }

    @Override
    public UtilisateurRes update(UtilisateurRes utilisateurRes,String id) {
        userDao.findById(id).orElseThrow(()-> new EntityNotFoundException("Client Not Found"));

        User userSaved = modelMapper.map(utilisateurRes,User.class);
        userSaved.setId(id);
        userDao.save(userSaved);
        return modelMapper.map(userSaved, UtilisateurRes.class);
    }

    @Override
    public List<UtilisateurRes> findAll() {
        return userDao.findAll()
                .stream().map(
                    el -> modelMapper.map( el ,UtilisateurRes.class)
                )
                .collect(Collectors.toList());
    }

    @Override
    public void saveUsersFromJson(MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users = objectMapper.readValue(file.getInputStream(), new TypeReference<List<User>>() {});

        // Sauvegarder les utilisateurs dans la base de données

        users.forEach(el -> el.setPassWord(passwordEncoder.encode(el.getPassword())));
        users.forEach(user -> System.out.println("Utilisateur traité : " + user.getEmail()));

        userDao.saveAll(users);
    }

    @Override
    public User findByid(String id) {
        return userDao.findById(id).orElseThrow(()-> new EntityNotFoundException("User not found"));
    }
    
}
