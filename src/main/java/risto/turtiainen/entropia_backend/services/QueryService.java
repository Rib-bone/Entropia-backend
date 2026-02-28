package risto.turtiainen.entropia_backend.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import risto.turtiainen.entropia_backend.entities.Maturity;
import risto.turtiainen.entropia_backend.entities.Mob;
import risto.turtiainen.entropia_backend.models.QueryRequestDto;
import risto.turtiainen.entropia_backend.models.QueryResponseDto;
import risto.turtiainen.entropia_backend.repositories.MaturityRepository;
import risto.turtiainen.entropia_backend.repositories.MobRepository;

import java.util.List;

@Service
public class QueryService {

    private final Logger log = LoggerFactory.getLogger(QueryService.class);

    private final MaturityRepository maturityRepository;

    public QueryService(MaturityRepository maturityRepository) {
        this.maturityRepository = maturityRepository;
    }

    public QueryResponseDto findHuntableMobsByUserData(QueryRequestDto requestDto) {
        log.info(requestDto.toString());
        double preferredMobHealth = requestDto.damage() * requestDto.preferredShotAmount();
        List<Maturity> maturities = maturityRepository.findByHealthBetween(preferredMobHealth - requestDto.damage(), preferredMobHealth + requestDto.damage());
        log.info(maturities.toString());
        return new QueryResponseDto(maturities);
    }
}
