package luisQuiroz.BE_W5_D5.services;


import luisQuiroz.BE_W5_D5.entities.Viaggio;
import luisQuiroz.BE_W5_D5.payloads.ViaggiPayloads.ViaggioDTO;
import luisQuiroz.BE_W5_D5.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;


    public Viaggio save(ViaggioDTO body){
        // controlli vari
        Viaggio viaggio = new Viaggio(body.destination(), body.date(), body.statoViaggio());
        return this.viaggioRepository.save(viaggio);
    }

}
