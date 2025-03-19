package bouda.med.company.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bouda.med.company.models.MecanismSuivre;
import bouda.med.company.models.ResultatRenion;

@Repository
public interface MecanismeSuivreDao extends JpaRepository<MecanismSuivre,String>{
    Optional<MecanismSuivre> findTopByOrderByIdDesc();

    List<MecanismSuivre> findByResult(ResultatRenion result);
}
