package risto.turtiainen.entropia_backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import risto.turtiainen.entropia_backend.models.QueryRequestDto;
import risto.turtiainen.entropia_backend.models.QueryResponseDto;
import risto.turtiainen.entropia_backend.services.QueryService;

@RestController
@RequestMapping("/v1")
public class QueryController {

    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/query")
    QueryResponseDto getMobByUserData(QueryRequestDto requestDto) {
        return queryService.findHuntableMobsByUserData(requestDto);
    }
}
