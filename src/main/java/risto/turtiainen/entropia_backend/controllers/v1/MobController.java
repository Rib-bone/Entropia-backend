package risto.turtiainen.entropia_backend.controllers.v1;

import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import risto.turtiainen.entropia_backend.entities.Mob;
import risto.turtiainen.entropia_backend.repositories.MobRepository;
import risto.turtiainen.entropia_backend.services.MobService;

@RestController
public class MobController implements v1Controller{

    private final MobRepository repository;

    private final MobService service;

    public MobController(MobRepository repository, MobService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/mobs")
    ResponseEntity<@NonNull Iterable<Mob>> getAll() {
        return  ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/mobs/{id}")
    ResponseEntity<@NonNull Mob> getMob(@PathVariable long id) {
        return ResponseEntity.ok(service.getMob(id));
    }
}
