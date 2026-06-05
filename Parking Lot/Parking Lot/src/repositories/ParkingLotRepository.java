package repositories;

import models.ParkingLot;

import java.util.Optional;

public interface ParkingLotRepository {

    public void save(ParkingLot parkingLot);
    public Optional<ParkingLot> getParkingLotById(long id);

}
