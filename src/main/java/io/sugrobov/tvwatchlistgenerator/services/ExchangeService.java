package io.sugrobov.tvwatchlistgenerator.services;

import io.sugrobov.tvwatchlistgenerator.domain.entities.Exchange;

import java.util.List;
import java.util.Set;

public interface ExchangeService {
    List<Exchange> getExchanges();

    Exchange getExchange(String name);
}
