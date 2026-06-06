package services;

import enums.PaymentMode;
import models.Bill;

public interface PaymentService {

    public Bill makePayment(Bill bill, double amount, PaymentMode paymentMode);
}
