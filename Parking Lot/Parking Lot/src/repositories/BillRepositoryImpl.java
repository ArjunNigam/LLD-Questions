package repositories;
import models.Bill;

import java.util.*;

public class BillRepositoryImpl implements BillRepository {
    private Map<Long, Bill> billMap;
    private static long billId;

    public BillRepositoryImpl() {
        billMap = new HashMap<>();
        billId = 0;
    }

    @Override
    public void save(Bill bill) {
        if(bill.getId() == 0)
        {
            bill.setId(++billId);
        }
        billMap.put(bill.getId(), bill);

    }

    @Override
    public Optional<Bill> getBillById(long id) {
        return Optional.ofNullable(billMap.get(id));
    }
}
