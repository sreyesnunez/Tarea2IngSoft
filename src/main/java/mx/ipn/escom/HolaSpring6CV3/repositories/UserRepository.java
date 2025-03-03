package mx.ipn.escom.HolaSpring6CV3.repositories;

import mx.ipn.escom.HolaSpring6CV3.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
