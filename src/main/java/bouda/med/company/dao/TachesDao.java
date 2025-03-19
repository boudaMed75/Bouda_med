package bouda.med.company.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bouda.med.company.models.Taches;

@Repository
public interface TachesDao extends JpaRepository<Taches,String>{


    Optional<Taches> findTopByOrderByIdDesc();
    
    
}
