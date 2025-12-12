package risto.turtiainen.entropia_backend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import risto.turtiainen.entropia_backend.entity.Item;
import risto.turtiainen.entropia_backend.entity.Mob;
import risto.turtiainen.entropia_backend.repository.ItemRepository;
import risto.turtiainen.entropia_backend.repository.MobRepository;

@RestController
public class ItemController {

    @Resource
    private final ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/items")
    Iterable<Item> all() {
        return repository.findAll();
    }
}
