package com.example.eventsourcing.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.eventsourcing.domain.AccountEvent;

@Repository
public class EventStoreRepository {
    private final List<AccountEvent> eventStore = new ArrayList<>();

    public void save(AccountEvent event) {
        eventStore.add(event);
    }

    public List<AccountEvent> getEventsByAccountId(String accountId) {
        return eventStore.stream()
                .filter(e -> e.getAccountId().equals(accountId))
                .toList();
    }
}

