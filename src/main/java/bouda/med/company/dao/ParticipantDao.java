package bouda.med.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bouda.med.company.models.Participant;
import java.util.List;
import java.util.Optional;


@Repository
public interface ParticipantDao extends JpaRepository<Participant,Long> {
    Optional<Participant> findById(Long id);
    Optional<Participant> findByEmail(String email);
    
}
