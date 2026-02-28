package risto.turtiainen.entropia_backend.repositories;

import org.springframework.data.repository.CrudRepository;
import risto.turtiainen.entropia_backend.entities.Maturity;
import risto.turtiainen.entropia_backend.entities.Mob;

import java.util.List;


public interface MaturityRepository extends CrudRepository<Maturity, Long> {

    List<Maturity> findByHealthBetween(double min, double max);
}
