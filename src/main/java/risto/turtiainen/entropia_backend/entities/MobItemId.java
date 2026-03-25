package risto.turtiainen.entropia_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class MobItemId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "mob_id", referencedColumnName = "id")
    @JsonIgnore
    private Mob mob;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

}
