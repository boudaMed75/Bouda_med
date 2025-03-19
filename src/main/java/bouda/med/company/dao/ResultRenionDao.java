package bouda.med.company.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bouda.med.company.models.DemandeEn;
import bouda.med.company.models.ResultatRenion;

@Repository
public interface ResultRenionDao extends JpaRepository<ResultatRenion,String>{

    Optional<ResultatRenion> findTopByOrderByIdDesc();
    
    List<DemandeEn> findByResDemande(DemandeEn resDemande);
}
