package bouda.med.company.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,String> {

    Optional<User> findByEmail(String email);

    Optional<User> findTopByOrderByIdDesc();
    
}
