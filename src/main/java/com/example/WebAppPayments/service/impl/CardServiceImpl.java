package com.example.WebAppPayments.service.impl;

import com.example.WebAppPayments.dao.impl.AccountDAOImpl;
import com.example.WebAppPayments.dao.impl.CardDAOImpl;
import com.example.WebAppPayments.dao.impl.UserDAOImpl;
import com.example.WebAppPayments.entity.Card;
import com.example.WebAppPayments.entity.User;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.service.CardService;

import java.util.ArrayList;
import java.util.List;

public class CardServiceImpl implements CardService {

    private static final CardServiceImpl instance = new CardServiceImpl();

    public static CardServiceImpl getInstance() {
        return instance;
    }

    private CardServiceImpl() {
    }

    private static final CardDAOImpl cardDAO = CardDAOImpl.getInstance();

    @Override
    public void extendCardValidDate(String newDate, int id) throws ServiceException {
        try {
            cardDAO.extendValidCard(newDate, id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Card> getCardsList(int id_account) throws ServiceException {
        List<Card> cardList = new ArrayList<>();
        try {
            cardList = cardDAO.getCardList(id_account);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return cardList;
    }

    @Override
    public void addNewCard(Card card) throws ServiceException {
        try {
            cardDAO.addNewCard(card);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
