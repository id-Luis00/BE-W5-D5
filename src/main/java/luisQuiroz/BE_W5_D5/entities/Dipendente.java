package luisQuiroz.BE_W5_D5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Dipendente {


    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String username;
    private String name;
    private String surname;
    private String email;
}
