package io.sugrobov.tvwatchlistgenerator.in.controllers;

import io.sugrobov.tvwatchlistgenerator.facades.WatchlistsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/whatchlists")
public class WatchlistsController {
    private final WatchlistsFacade watchlistsFacade;

    @GetMapping
    public ResponseEntity<Void> getWatchLists(@RequestParam String exchangeName) {
        this.watchlistsFacade.getAllWatchListsForExchange(exchangeName);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
