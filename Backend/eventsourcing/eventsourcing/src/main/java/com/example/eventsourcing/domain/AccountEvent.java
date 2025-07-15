package com.example.eventsourcing.domain;

import java.time.Instant;

public abstract class AccountEvent {
    private final String accountId;
    private final Instant timestamp;

    protected AccountEvent(String accountId) {
        this.accountId = accountId;
        this.timestamp = Instant.now();
    }

    public String getAccountId() {
        return accountId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public abstract String getType();
}

