package bouda.med.company.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bouda.med.company.models.Chapitre;
import bouda.med.company.models.Modules;
import bouda.med.company.models.SousModules;

@Repository
public interface ChapitreDao extends JpaRepository<Chapitre,String>{

    Optional<Chapitre> findTopByOrderByIdDesc();
    List<Chapitre> findBySousModules(SousModules sousModules);
    
}
