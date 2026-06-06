package services;

import models.Bill;
import models.Gate;
import models.ParkingLot;
import models.Ticket;

public interface BillService {

    public Bill generateBill(ParkingLot parkingLot, Ticket ticket, Gate exitGate);
}
