package luisQuiroz.BE_W5_D5.services;


import luisQuiroz.BE_W5_D5.entities.Viaggio;
import luisQuiroz.BE_W5_D5.exceptions.NotFoundException;
import luisQuiroz.BE_W5_D5.payloads.ViaggiPayloads.ViaggioDTO;
import luisQuiroz.BE_W5_D5.payloads.ViaggiPayloads.ViaggioStatoDTO;
import luisQuiroz.BE_W5_D5.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;


    public Page<Viaggio> findAll(int page, int size){

        Pageable pageable = PageRequest.of(page, size);

        return this.viaggioRepository.findAll(pageable);
    }

    public Viaggio findById(UUID viaggioId){
        return this.viaggioRepository.findById(viaggioId).orElseThrow(() -> new NotFoundException("Viaggio non trovato con l'id " + viaggioId));
    }

    public Viaggio save(ViaggioDTO body){
        // controlli vari
        Viaggio viaggio = new Viaggio(body.destination(), body.date(), body.statoViaggio());
        return this.viaggioRepository.save(viaggio);
    }

    public Viaggio findAndUpdate(UUID viaggioId, ViaggioDTO body) {
        Viaggio foundViaggio = this.findById(viaggioId);
        foundViaggio.setDestionation(body.destination());
        foundViaggio.setDate(body.date());
        foundViaggio.setStatoViaggio(body.statoViaggio());

        this.viaggioRepository.save(foundViaggio);

        return foundViaggio;
    }

    public Viaggio findAndUpdateStato(UUID viaggioId, ViaggioStatoDTO body){
        Viaggio foundViaggio = this.findById(viaggioId);
        foundViaggio.setStatoViaggio(body.statoViaggio());
        this.viaggioRepository.save(foundViaggio);
        return foundViaggio;
    }

    public void findAndDelete(UUID viaggioId) {
       Viaggio viaggioFound = this.findById(viaggioId);
       this.viaggioRepository.delete(viaggioFound);
    }

}
