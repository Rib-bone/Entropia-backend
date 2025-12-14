package risto.turtiainen.entropia_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "mob_item")
public class MobItem {

    @Id
    @ManyToOne
    @JoinColumn(name = "mob_id", referencedColumnName = "id")
    @JsonIgnore
    private Mob mob;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    private String frequency;

}
