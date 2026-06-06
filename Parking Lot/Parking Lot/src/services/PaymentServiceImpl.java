package services;

import enums.*;
import models.Bill;
import models.Payment;
import repositories.BillRepository;
import repositories.PaymentRepository;

import java.util.Date;

public class PaymentServiceImpl implements PaymentService{

    /*
    Attributes in PaymentClass
    private Bill bill;
    private double amount;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
    private Date timestamp;
     */
    private PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository)
    {
        this.paymentRepository = paymentRepository;

    }
    @Override
    public Bill makePayment(Bill bill, double amount, PaymentMode paymentMode) {

        Payment payment = new Payment();
        payment.setBill(bill);
        payment.setAmount(amount);
        payment.setPaymentStatus(PaymentStatus.SUCCESSFUL);
        payment.setPaymentMode(paymentMode);
        payment.setTimestamp(new Date());
        paymentRepository.save(payment);
        bill.getPayments().add(payment);
        closeTicketIfPaid(bill);
        return bill;



    }

    private void closeTicketIfPaid(Bill bill)
    {
        double paidAmount = 0;
        for(Payment payment : bill.getPayments())
        {
            double amount = payment.getAmount();
            paidAmount += amount;
            if(paidAmount >= bill.getAmount())
            {
                bill.setBillStatus(BillStatus.PAID);
                bill.getTicket().setStatus(TicketStatus.INACTIVE);
                bill.getTicket().getAssignedParkingSpot().setStatus(ParkingSpotStatus.AVAILABLE);
                return;
            }
        }

        if (paidAmount != 0)
        {
            bill.setBillStatus(BillStatus.PARTIALLY_PAID);
        }
    }

}
