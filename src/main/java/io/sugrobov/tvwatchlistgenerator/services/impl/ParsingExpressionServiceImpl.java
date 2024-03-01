package io.sugrobov.tvwatchlistgenerator.services.impl;

import io.sugrobov.tvwatchlistgenerator.domain.entities.Contract;
import io.sugrobov.tvwatchlistgenerator.domain.entities.Exchange;
import io.sugrobov.tvwatchlistgenerator.services.ParsingExpressionService;
import org.springframework.stereotype.Service;

@Service
public class ParsingExpressionServiceImpl implements ParsingExpressionService {
    @Override
    public String getExpression(Exchange exchange, Contract contract) {
        return "$.data[?(@.io contains '" + exchange.getName() + "')].symbol";
    }
}
