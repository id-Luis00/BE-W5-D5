package luisQuiroz.BE_W5_D5.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Prenotazione {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private LocalDate dateBooking;
    private String preferences;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;

    public Prenotazione(LocalDate dateBooking, String preferences, Dipendente dipendente, Viaggio viaggio) {
        this.dateBooking = dateBooking;
        this.preferences = preferences;
        this.dipendente = dipendente;
        this.viaggio = viaggio;
    }
}
