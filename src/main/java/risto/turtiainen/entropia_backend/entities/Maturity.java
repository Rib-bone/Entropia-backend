package risto.turtiainen.entropia_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

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

    @OneToMany(mappedBy = "id.maturity")
    private List<MobDamageType> damageTypes;
}
