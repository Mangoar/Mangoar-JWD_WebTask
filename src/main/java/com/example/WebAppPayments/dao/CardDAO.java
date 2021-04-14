package com.example.WebAppPayments.dao;

import com.example.WebAppPayments.entity.Card;
import com.example.WebAppPayments.exception.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CardDAO {

    void blockCard(int id) throws DaoException;

    void extendValidCard(String newDate, int id) throws DaoException;

    List<Card> getCardList(int id_account) throws DaoException;

    List<Card> getCardInfo(ResultSet resultSet) throws SQLException;


    void addNewCard(Card card) throws DaoException;
}
