package risto.turtiainen.entropia_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor(force = true)
@Table(name = "item")
public class Item {

    @Id
    private int id;
    private String name;
    private String type;
    @Column(name = "max_tt")
    private Float ttValue;
    private String markup;

    @OneToMany(mappedBy = "item")
    @JsonIgnore
    private List<MobItem> mobs;

}
