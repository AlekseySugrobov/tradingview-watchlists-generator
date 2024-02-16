package io.sugrobov.tvwatchlistgenerator.domain.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum ContractType {
    SPOT, FUTURES("P");

    private final String symbol;

    ContractType() {
        this.symbol = StringUtils.EMPTY;
    }

    ContractType(String symbol) {
        this.symbol = symbol;
    }
}
