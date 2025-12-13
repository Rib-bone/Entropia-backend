package risto.turtiainen.entropia_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "mob_item",
            joinColumns = { @JoinColumn(name = "mob_id") },
            inverseJoinColumns = { @JoinColumn(name = "item_id") }
    )
    private List<Item> items;

}
