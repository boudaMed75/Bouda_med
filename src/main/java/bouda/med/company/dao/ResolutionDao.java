package bouda.med.company.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bouda.med.company.models.Objectif;
import bouda.med.company.models.Resolution;

@Repository
public interface ResolutionDao extends JpaRepository<Resolution,String>{

    Optional<Resolution> findTopByOrderByIdDesc();

    List<Resolution> findByObjectif(Objectif objectif);
    
}
