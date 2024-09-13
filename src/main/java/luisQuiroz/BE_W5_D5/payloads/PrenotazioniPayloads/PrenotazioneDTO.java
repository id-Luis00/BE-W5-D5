package luisQuiroz.BE_W5_D5.payloads.PrenotazioniPayloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record PrenotazioneDTO(
        @NotEmpty(message = "È obbligatorio inserire una data di prenotazione")
        LocalDate dateBooking,
        @Size(min = 0, max = 240)
        String preferences,

        @NotEmpty(message = "È obbligatorio inserire il codice del dipendente")
        String dipendenteId,
        @NotEmpty(message = "È obbligatorio inserire il codice del viaggio")
        String viaggioId
) {}
