package luisQuiroz.BE_W5_D5.repositories;


import luisQuiroz.BE_W5_D5.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, UUID> {
    boolean existsByEmail(String email);
}
