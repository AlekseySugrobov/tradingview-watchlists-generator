package io.sugrobov.tvwatchlistgenerator.services;

import io.sugrobov.tvwatchlistgenerator.domain.entities.Contract;
import io.sugrobov.tvwatchlistgenerator.domain.entities.Exchange;

public interface ParsingExpressionService {
    String getExpression(Exchange exchange, Contract contract);
}
