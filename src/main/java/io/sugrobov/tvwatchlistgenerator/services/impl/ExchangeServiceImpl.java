package io.sugrobov.tvwatchlistgenerator.services.impl;

import io.sugrobov.tvwatchlistgenerator.domain.entities.Exchange;
import io.sugrobov.tvwatchlistgenerator.exceptions.ExchangeNotFoundException;
import io.sugrobov.tvwatchlistgenerator.repositories.ExchangeRepository;
import io.sugrobov.tvwatchlistgenerator.services.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {
    private final ExchangeRepository exchangeRepository;

    @Override
    public List<Exchange> getExchanges() {
        return this.exchangeRepository.findAll();
    }

    @Override
    public Exchange getExchange(String name) {
        return this.exchangeRepository.findByName(name)
                .orElseThrow(() -> new ExchangeNotFoundException("Unable find exchange by name " + name));
    }
}
