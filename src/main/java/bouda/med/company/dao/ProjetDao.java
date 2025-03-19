package bouda.med.company.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bouda.med.company.models.Projet;
import bouda.med.company.user.User;

@Repository
public interface ProjetDao extends JpaRepository<Projet,String>{

    Optional<Projet> findTopByOrderByProjectIDDesc();

    Optional<Projet> findByChef(User user);

    @Query("SELECT p FROM Projet p WHERE YEAR(p.start_date) <= :year AND YEAR(p.end_date) >= :year")
    List<Projet> findProjectsByYear(@Param("year") int year);

    @Query("SELECT p FROM Projet p WHERE p.start_date <= :currentDate AND p.end_date >= :currentDate")
    Optional<Projet> findCurrentProjects(@Param("currentDate") LocalDateTime currentDate);

    
}
