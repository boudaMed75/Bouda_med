package bouda.med.company.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bouda.med.company.models.Modules;
import bouda.med.company.models.Projet;
import bouda.med.company.user.User;

@Repository
public interface ModuleDao extends JpaRepository<Modules,String>{

    Optional<Modules> findTopByOrderByIdDesc();

    List<Modules> findByProjetAndEncadrant(Projet projet,User user);

    List<Modules> findByEncadrant(User user);

    List<Modules> findByProjet(Projet pro);
    
}
