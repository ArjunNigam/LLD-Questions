package repositories;

import models.Payment;

import java.util.Optional;

public interface PaymentRepository {

    public void save(Payment payment);
    public Optional<Payment> getPaymentById(long id);
}
