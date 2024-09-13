package luisQuiroz.BE_W5_D5.controllers;


import luisQuiroz.BE_W5_D5.payloads.ViaggiPayloads.ViaggioDTO;
import luisQuiroz.BE_W5_D5.payloads.ViaggiPayloads.ViaggioRespDTO;
import luisQuiroz.BE_W5_D5.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;




    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViaggioRespDTO saveNewViaggio(@RequestBody ViaggioDTO body){
       return new ViaggioRespDTO(this.viaggioService.save(body).getId());
    }
}
