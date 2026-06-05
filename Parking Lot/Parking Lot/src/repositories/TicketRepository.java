package repositories;

import models.Ticket;

import java.util.Optional;

public interface TicketRepository {

    public void save(Ticket ticket);
    public Optional<Ticket> getTicketById(long id);
}
