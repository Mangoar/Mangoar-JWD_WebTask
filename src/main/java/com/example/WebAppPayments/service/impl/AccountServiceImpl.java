package com.example.WebAppPayments.service.impl;

import com.example.WebAppPayments.dao.impl.AccountDAOImpl;
import com.example.WebAppPayments.entity.Account;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.service.AccountService;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private static final AccountServiceImpl instance = new AccountServiceImpl();

    public static AccountServiceImpl getInstance() {
        return instance;
    }

    private AccountServiceImpl() {
    }

    private static final AccountDAOImpl accountDAO = AccountDAOImpl.getInstance();

    @Override
    public List<Account> getAccountList(int id_user) throws ServiceException {
        List<Account> accountList = new ArrayList<>();
        try {
            accountList = accountDAO.getAccountList(id_user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        return accountList;
    }


    @Override
    public void outcomeValueAccount(int account, double curr_value, double value) throws ServiceException {
        double new_value = curr_value - value;
        try {
            accountDAO.changeValueAccount(account, new_value);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void incomeValueAccount(int account, double curr_value, double value) throws ServiceException {
        double new_value = curr_value + value;
        try {
            accountDAO.changeValueAccount(account, new_value);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addNewAccount(Account account) throws ServiceException {
        try {
            accountDAO.addNewAccount(account);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
