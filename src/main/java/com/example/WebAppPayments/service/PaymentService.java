package com.example.WebAppPayments.service;

import com.example.WebAppPayments.entity.Payment;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.ServiceException;

import java.util.List;

public interface PaymentService {

    void addNewPayment(Payment payment) throws DaoException, ServiceException;

    List<Payment> getPaymentsList(int user_id) throws DaoException, ServiceException;
}
