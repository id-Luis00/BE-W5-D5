package luisQuiroz.BE_W5_D5.services;




import luisQuiroz.BE_W5_D5.entities.Dipendente;
import luisQuiroz.BE_W5_D5.exceptions.BadRequestException;
import luisQuiroz.BE_W5_D5.payloads.DipendentiPayloads.DipendenteDTO;
import luisQuiroz.BE_W5_D5.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Page<Dipendente> findAllDipendenti(int page, int size){

        Pageable pageable = PageRequest.of(page, size);

        return this.dipendenteRepository.findAll(pageable);
    }

    public Dipendente save(DipendenteDTO body){
        // controlliamo che l'email non esista di già
        if (this.dipendenteRepository.existsByEmail(body.email())) throw new BadRequestException("L'email esiste già");

        // inseriamo i dati server-generated... dopo

        // salviamo il tutto
        Dipendente newDipendente = new Dipendente(body.username(), body.name(), body.surname(), body.email());

        return this.dipendenteRepository.save(newDipendente);
    }

}
