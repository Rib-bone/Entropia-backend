package risto.turtiainen.entropia_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import risto.turtiainen.entropia_backend.enums.DamageTypeEnum;

@Entity
@Data
@NoArgsConstructor(force = true)
@Table(name = "damage_type")
public class DamageType {

    @Id
    private int id;

    @Enumerated(EnumType.STRING)
    private final DamageTypeEnum damageType;

}