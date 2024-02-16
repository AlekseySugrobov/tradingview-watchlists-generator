package io.sugrobov.tvwatchlistgenerator.facades;

import com.jayway.jsonpath.JsonPath;
import io.sugrobov.tvwatchlistgenerator.domain.entities.Contract;
import io.sugrobov.tvwatchlistgenerator.domain.entities.Exchange;
import io.sugrobov.tvwatchlistgenerator.services.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
@RequiredArgsConstructor
public class WatchlistsFacade {
    private final RestTemplate restTemplate;
    private final ExchangeService exchangeService;

    public void getAllWatchListsForExchange(String name) {
        Exchange exchange = this.exchangeService.getExchange(name);
        for (Contract contract:exchange.getContracts()) {
            ResponseEntity<String> response =
                    restTemplate.getForEntity(URI.create(contract.getMethodUrl()), String.class);
            List<String> result = JsonPath.read(response.getBody(),
                    "$.data[?(@.io contains '" + exchange.getName() + "')].symbol");
        }
    }
}
