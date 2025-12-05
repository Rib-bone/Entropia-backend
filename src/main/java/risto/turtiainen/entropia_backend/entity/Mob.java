package risto.turtiainen.entropia_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "mob")
public class Mob {
    @Id
    private int id;
    private String name;
    //private MobType type;
}
