package com.example.WebAppPayments.dao;

import com.example.WebAppPayments.entity.User;
import com.example.WebAppPayments.exception.ConnectionPoolException;
import com.example.WebAppPayments.exception.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO{

    void addUser(User user) throws ConnectionPoolException, DaoException;

    User getUserByLoginInfo(String login, String password) throws DaoException;

    List<User> getUserInfo(ResultSet resultSet) throws SQLException;

    List<User> getUserList() throws DaoException;

    void blockUser(int userId) throws DaoException;

    void unblockUser(int userId) throws DaoException;

    void updateUserData(int userId, String newPasswordString, String newFullnameString, String newPassportString, String newEmailString) throws DaoException;

    User getUserById(String id) throws DaoException;
}
