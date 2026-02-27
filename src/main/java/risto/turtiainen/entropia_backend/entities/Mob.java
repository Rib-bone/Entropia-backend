package risto.turtiainen.entropia_backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import risto.turtiainen.entropia_backend.enums.MobType;

import java.util.List;

@Data
@Entity
@NoArgsConstructor(force = true)
@Table(name = "mob")
public class Mob {

    @Id
    private int id;
    private String name;

    @Enumerated(EnumType.STRING)
    private final MobType type;

    @OneToMany(mappedBy="mob")
    private List<Maturity> maturities;

    @OneToMany(mappedBy = "mob")
    private List<MobItem> items;

}
