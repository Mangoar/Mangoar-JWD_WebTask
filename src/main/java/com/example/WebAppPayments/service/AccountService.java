package com.example.WebAppPayments.service;

import com.example.WebAppPayments.entity.Account;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.ServiceException;

import java.util.List;

public interface AccountService {

    List<Account> getAccountList(int id_user) throws ServiceException;

    void outcomeValueAccount(int account, double curr_value, double value) throws ServiceException;

    void incomeValueAccount(int account, double curr_value, double value) throws ServiceException;

    void addNewAccount(Account account) throws ServiceException;
}
