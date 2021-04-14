package com.example.WebAppPayments.dao;

import com.example.WebAppPayments.entity.Payment;
import com.example.WebAppPayments.exception.DaoException;

import java.util.List;

public interface PaymentDAO {

    void addPayment(Payment payment) throws DaoException;

    List<Payment> getPaymentList(int user_id) throws DaoException;

    List<Payment> getYearPaymentList(int user_id) throws DaoException;

    List<Payment> getMonthPaymentList(int user_id) throws DaoException;

    List<Payment> getWeekPaymentList(int user_id) throws DaoException;

    List<Payment> getLastPaymentList(int user_id) throws DaoException;
}
