package risto.turtiainen.entropia_backend.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import risto.turtiainen.entropia_backend.models.QueryRequestDto;
import risto.turtiainen.entropia_backend.models.QueryResponseDto;

@Service
public class QueryService {

    private final Logger log = LoggerFactory.getLogger(QueryService.class);

    public QueryResponseDto findHuntableMobsByUserData(QueryRequestDto requestDto) {
        log.info(requestDto.toString());
        return null;
    };
}
