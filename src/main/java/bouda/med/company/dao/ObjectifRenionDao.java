package bouda.med.company.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bouda.med.company.models.Objectif;
import bouda.med.company.models.Renion;

@Repository
public interface ObjectifRenionDao extends JpaRepository<Objectif,String> {

    Optional<Objectif> findTopByOrderByIdDesc();

    List<Objectif> findByObjRenion(Renion objRenion);


}
