package luisQuiroz.BE_W5_D5.payloads.ViaggiPayloads;

import jakarta.validation.constraints.NotEmpty;
import luisQuiroz.BE_W5_D5.enums.StatoViaggio;

public record ViaggioStatoDTO(
        @NotEmpty(message = "È obbligatorio inserire uno stato")
        @ValidEnum(enumClass = StatoViaggio.class, message = "Stato del viaggio non valido")
        StatoViaggio statoViaggio
) {
}
