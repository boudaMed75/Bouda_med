package bouda.med.company.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bouda.med.company.token.Token;

public interface TokenDao extends JpaRepository<Token,Long> {

    //  @Query(value = """
    //   select t from Token t inner join user u\s
    //   on t.user.id = u.id\s
    //   where u.id = :id and (t.expired = false or t.revoked = false)\s
    //   """)
    // List<Token> findAllValidTokenByUser(Long id);
    @Query(value = """
    select t from Token t
    where t.user.id = :id and (t.expired = false or t.revoked = false)
""")
List<Token> findAllValidTokenByUser(@Param("id") String id);

    Optional<Token> findByToken(String token);
    
}
