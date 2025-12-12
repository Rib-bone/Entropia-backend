package risto.turtiainen.entropia_backend.repository;

import org.springframework.data.repository.CrudRepository;
import risto.turtiainen.entropia_backend.entity.Item;


public interface ItemRepository extends CrudRepository<Item, Long> {

}
