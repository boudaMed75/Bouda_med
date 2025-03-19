package bouda.med.company.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bouda.med.company.models.DemandeEn;
import bouda.med.company.models.Modules;
import bouda.med.company.models.Renion;


@Repository
public interface DemnadeEnDao extends JpaRepository<DemandeEn,String> {

    Optional<DemandeEn> findTopByOrderByIdDesc();

    List<DemandeEn> findByDemandeRenion(Renion demandeRenion);

    List<DemandeEn> findByDemandedModel(Modules demandedModel);

    List<DemandeEn> findByAcceptation(boolean acceptation);
    
}
