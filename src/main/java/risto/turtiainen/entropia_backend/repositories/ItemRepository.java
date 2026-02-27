package risto.turtiainen.entropia_backend.repositories;

import org.springframework.data.repository.CrudRepository;
import risto.turtiainen.entropia_backend.entities.Item;


public interface ItemRepository extends CrudRepository<Item, Long> {

}
