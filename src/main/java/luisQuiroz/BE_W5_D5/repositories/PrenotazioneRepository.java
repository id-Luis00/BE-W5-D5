package luisQuiroz.BE_W5_D5.repositories;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import luisQuiroz.BE_W5_D5.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

    boolean existsByViaggioDateAndDipendenteId(LocalDate dateBooking, UUID dipendenteId);

}
