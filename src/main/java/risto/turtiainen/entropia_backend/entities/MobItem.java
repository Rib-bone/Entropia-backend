package risto.turtiainen.entropia_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mob_item")
public class MobItem {

    @EmbeddedId
    private MobItemId id;

    private String frequency;

}
