package risto.turtiainen.entropia_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class DamageType {
    @Id
    private int id;
    private Integer stab;
    private Integer cut;
    private Integer impact;
    private Integer penetration;
    private Integer shrapnel;
    private Integer burn;
    private Integer cold;
    private Integer acid;
    private Integer electric;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Mob mob;

    @OneToOne
    @JsonIgnore
    @ToString.Exclude
    private Maturity maturity;
}