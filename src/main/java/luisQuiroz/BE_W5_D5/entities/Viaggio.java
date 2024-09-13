package luisQuiroz.BE_W5_D5.entities;


import jakarta.persistence.*;
import lombok.*;
import luisQuiroz.BE_W5_D5.enums.StatoViaggio;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Viaggio {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String destionation;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private StatoViaggio statoViaggio;

    public Viaggio(String destionation, LocalDate date, StatoViaggio statoViaggio) {
        this.destionation = destionation;
        this.date = date;
        this.statoViaggio = statoViaggio;
    }
}
