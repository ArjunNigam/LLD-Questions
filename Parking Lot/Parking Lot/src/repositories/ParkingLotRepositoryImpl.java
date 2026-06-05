package repositories;

import models.ParkingLot;
import java.util.*;
import java.util.Optional;

public class ParkingLotRepositoryImpl implements ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLotMap;
    private static long parkingLotId;

    public ParkingLotRepositoryImpl() {
        parkingLotMap = new HashMap<>();
        parkingLotId = 0;
    }

    @Override
    public void save(ParkingLot parkingLot) {
        if(parkingLot.getId() == 0)
        {
            parkingLot.setId(++parkingLotId);
        }
        parkingLotMap.put(parkingLot.getId(), parkingLot);

    }

    @Override
    public Optional<ParkingLot> getParkingLotById(long id) {
        return Optional.ofNullable(parkingLotMap.get(id));
    }
}
