package risto.turtiainen.entropia_backend.controllers.v1;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import risto.turtiainen.entropia_backend.models.QueryRequestDto;
import risto.turtiainen.entropia_backend.models.QueryResponseDto;
import risto.turtiainen.entropia_backend.services.QueryService;

@RestController
public class QueryController implements v1Controller{

    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @PostMapping("/query")
    QueryResponseDto getMobByUserData(@RequestBody @Valid QueryRequestDto requestDto) {
        return queryService.findHuntableMobsByUserData(requestDto);
    }
}
