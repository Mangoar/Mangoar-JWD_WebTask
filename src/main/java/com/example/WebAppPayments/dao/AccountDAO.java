package com.example.WebAppPayments.dao;

import com.example.WebAppPayments.entity.Account;
import com.example.WebAppPayments.exception.DaoException;

import java.util.List;

public interface AccountDAO {

    List<Account> getAccountList(int id_user) throws DaoException;

    void changeValueAccount(int id_account, double value) throws DaoException;

    void addNewAccount(Account account) throws DaoException;

    void updateBalance(int id_account, double newValue) throws DaoException;
}

