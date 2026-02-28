package risto.turtiainen.entropia_backend.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import risto.turtiainen.entropia_backend.entities.Mob;
import risto.turtiainen.entropia_backend.exception.NotFoundException;
import risto.turtiainen.entropia_backend.repositories.MobRepository;

import java.util.Optional;

@Service
public class MobService {

    private final Logger log = LoggerFactory.getLogger(MobService.class);

    private final MobRepository repository;

    public MobService(MobRepository repository) {
        this.repository = repository;
    }

    public Mob getMob(long id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Mob with id " + id + " not found"));
    }
}
