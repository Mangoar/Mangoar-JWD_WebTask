package com.example.WebAppPayments.service;

import com.example.WebAppPayments.entity.Card;
import com.example.WebAppPayments.entity.User;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.ServiceException;

import java.util.List;

public interface CardService {

    void extendCardValidDate(String newDate, int id) throws ServiceException;

    List<Card> getCardsList(int id_account) throws ServiceException;

    void addNewCard(Card card) throws ServiceException;

}
