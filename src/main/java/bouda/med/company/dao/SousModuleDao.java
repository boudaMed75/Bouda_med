package bouda.med.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bouda.med.company.models.Modules;
import bouda.med.company.models.SousModules;
import java.util.List;
import java.util.Optional;


@Repository
public interface SousModuleDao extends JpaRepository<SousModules,String>{
    List<SousModules> findByModule(Modules module);
    Optional<SousModules> findTopByOrderByIdDesc();
}
