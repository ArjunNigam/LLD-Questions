package repositories;

import models.Bill;

import java.util.Optional;

public interface BillRepository {

    public void save(Bill bill);
    public Optional<Bill> getBillById(long id);
}
