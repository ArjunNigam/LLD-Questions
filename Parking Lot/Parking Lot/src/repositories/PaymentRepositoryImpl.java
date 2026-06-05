package repositories;

import models.Payment;

import java.util.HashMap;
import java.util.Optional;
import java.util.*;

public class PaymentRepositoryImpl implements PaymentRepository {
    private Map<Long, Payment> paymentMap;
    private static long paymentId;

    public PaymentRepositoryImpl() {
        paymentMap = new HashMap<>();
        paymentId = 0;
    }

    @Override
    public void save(Payment payment) {
        if(payment.getId() == 0)
        {
            payment.setId(++paymentId);
        }
        paymentMap.put(payment.getId(), payment);

    }

    @Override
    public Optional<Payment> getPaymentById(long id) {
        return Optional.ofNullable(paymentMap.get(id));
    }
}
