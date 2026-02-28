package risto.turtiainen.entropia_backend.controllers.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import risto.turtiainen.entropia_backend.entities.Item;
import risto.turtiainen.entropia_backend.repositories.ItemRepository;

@RestController
public class ItemController implements v1Controller {

    private final ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/items")
    Iterable<Item> all() {
        return repository.findAll();
    }
}
