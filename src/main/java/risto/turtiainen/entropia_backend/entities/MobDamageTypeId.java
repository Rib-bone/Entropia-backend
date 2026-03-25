package risto.turtiainen.entropia_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Embeddable
@Data
public class MobDamageTypeId implements Serializable {

    @OneToOne
    private DamageType damageType;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Mob mob;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Maturity maturity;

}
