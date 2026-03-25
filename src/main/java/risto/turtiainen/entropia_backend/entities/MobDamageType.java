package risto.turtiainen.entropia_backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "mob_damage_type")
public class MobDamageType {

    @EmbeddedId
    private MobDamageTypeId id;
    private Integer damageAmount;

}