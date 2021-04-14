package com.example.WebAppPayments.service.impl;

import com.example.WebAppPayments.dao.impl.AccountDAOImpl;
import com.example.WebAppPayments.dao.impl.CardDAOImpl;
import com.example.WebAppPayments.dao.impl.PaymentDAOImpl;
import com.example.WebAppPayments.entity.Card;
import com.example.WebAppPayments.entity.Payment;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.service.PaymentService;

import java.util.ArrayList;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private static final PaymentServiceImpl instance = new PaymentServiceImpl();

    public static PaymentServiceImpl getInstance() {
        return instance;
    }

    private PaymentServiceImpl() {
    }

    private static final PaymentDAOImpl paymentDAO = PaymentDAOImpl.getInstance();

    @Override
    public void addNewPayment(Payment payment) throws ServiceException {
        try {
            paymentDAO.addPayment(payment);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Payment> getPaymentsList(int user_id) throws ServiceException {
        List<Payment> paymentsList = new ArrayList<>();
        try {
        paymentsList = paymentDAO.getPaymentList(user_id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return paymentsList;
    }
}
