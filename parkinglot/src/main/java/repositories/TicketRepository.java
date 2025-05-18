package repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import models.Ticket;

public class TicketRepository {
    private Map<String, Ticket> dataMap = new HashMap<>();

    public Optional<Ticket> findById(String ticketNumber) {

        if (dataMap.containsKey(ticketNumber)) {
            return Optional.of(dataMap.get(ticketNumber));
        } else {
            return Optional.empty();
        }
    }

    public void save(Ticket ticket) {
        dataMap.put(ticket.getTickerNumber(), ticket);
    }
}
