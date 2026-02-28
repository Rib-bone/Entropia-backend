package risto.turtiainen.entropia_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "maturity")
public class Maturity {

    @Id
    private int id;
    private String name;
    private Integer health;
    private Integer attacksPerMinute;
    private Integer regenerationInterval;
    private Integer regenerationAmount;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Mob mob;

    //private Map<DamageType, Integer> damage;

   /* "Attributes": {
        "Strength": 104,
        "Agility": 226,
        "Intelligence": 99,
        "Psyche": 67,
        "Stamina": 100
    },
    "Defense": {
        "Stab": null,
        "Cut": null,
        "Impact": null,
        "Penetration": null,
        "Shrapnel": null,
        "Burn": null,
        "Cold": null,
        "Acid": null,
        "Electric": null
    }*/
}
