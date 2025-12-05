package risto.turtiainen.entropia_backend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import risto.turtiainen.entropia_backend.entity.Mob;
import risto.turtiainen.entropia_backend.repository.MobRepository;

import java.util.List;

@RestController
public class MobController {

    @Resource
    private final MobRepository repository;

    public MobController(MobRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/mobs")
    Iterable<Mob> all() {
        return repository.findAll();
    }
}
