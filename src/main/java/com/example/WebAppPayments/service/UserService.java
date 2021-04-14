package com.example.WebAppPayments.service;

import com.example.WebAppPayments.entity.User;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.ServiceException;

import java.util.List;

public interface UserService {

    User authorization(String login, String passport) throws ServiceException;

    void registration(User user) throws ServiceException;

    List<User> getAllUsers() throws ServiceException;

    User getUserById(String id) throws ServiceException;

    void unblockUser(int idUser) throws ServiceException;

    void blockUser(int idUser) throws ServiceException;

    void updateUserData(int idUser, String newPasswordString, String newFullnameString, String newPassportString, String newEmailString) throws ServiceException;
}
