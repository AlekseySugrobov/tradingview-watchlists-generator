package io.sugrobov.tvwatchlistgenerator.repositories;

import io.sugrobov.tvwatchlistgenerator.domain.entities.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, UUID> {
}
