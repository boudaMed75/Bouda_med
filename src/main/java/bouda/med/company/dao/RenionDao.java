package bouda.med.company.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bouda.med.company.models.Projet;
import bouda.med.company.models.Renion;

@Repository
public interface RenionDao extends JpaRepository<Renion,String>{

    Optional<Renion> findTopByOrderByIdDesc();

    List<Renion> findByProjetRenion(Projet projetRenion);
    
}
