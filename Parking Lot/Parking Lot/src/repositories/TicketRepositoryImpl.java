package repositories;
import java.util.*;
import models.Ticket;

public class TicketRepositoryImpl implements TicketRepository {

    private Map<Long, Ticket> ticketMap;
    private static long ticketId;

    public TicketRepositoryImpl() {
        ticketMap = new HashMap<>();
        ticketId = 0;
    }


    @Override
    public void save(Ticket ticket) {
        if(ticket.getId() == 0)
        {
            ticket.setId(++ticketId);
        }
        ticketMap.put(ticket.getId(), ticket);
    }

    @Override
    public Optional<Ticket> getTicketById(long id) {
        return Optional.ofNullable(ticketMap.get(id));
    }
}
