package io.sugrobov.tvwatchlistgenerator.facades;

import com.jayway.jsonpath.JsonPath;
import io.sugrobov.tvwatchlistgenerator.domain.entities.Contract;
import io.sugrobov.tvwatchlistgenerator.domain.entities.Exchange;
import io.sugrobov.tvwatchlistgenerator.services.ExchangeService;
import io.sugrobov.tvwatchlistgenerator.services.ParsingExpressionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@Component
@RequiredArgsConstructor
public class WatchlistsFacade {
    private final RestTemplate restTemplate;
    private final ExchangeService exchangeService;
    private final ParsingExpressionService parsingExpressionService;

    public void getAllWatchListsForExchange(String name) {
        Exchange exchange = this.exchangeService.getExchange(name);
        List<String> tradePairs = new ArrayList<>();
        for (Contract contract : exchange.getContracts()) {
            ResponseEntity<String> response =
                    restTemplate.getForEntity(URI.create(contract.getMethodUrl()), String.class);
            String parsingExpression = parsingExpressionService.getExpression(exchange, contract);
            tradePairs.addAll(((List<String>) JsonPath.read(response.getBody(), parsingExpression))
                    .stream()
                    .map(tradePair -> exchange.getName().toUpperCase(Locale.ROOT) + ":" + tradePair.replace("_", "") + "." + contract.getType().getSymbol())
                    .toList());
        }
        log.info("Got trade pairs: " + tradePairs);
    }
}
