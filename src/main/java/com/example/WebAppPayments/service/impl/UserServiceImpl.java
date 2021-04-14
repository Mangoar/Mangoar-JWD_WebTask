package com.example.WebAppPayments.service.impl;

import com.example.WebAppPayments.dao.impl.AccountDAOImpl;
import com.example.WebAppPayments.dao.impl.UserDAOImpl;
import com.example.WebAppPayments.entity.User;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.ServiceException;
import com.example.WebAppPayments.service.UserService;

import java.util.ArrayList;
import java.util.List;


public class UserServiceImpl implements UserService {

    private static final UserServiceImpl instance = new UserServiceImpl();

    public static UserServiceImpl getInstance() {
        return instance;
    }

    private UserServiceImpl() {
    }

    private static final UserDAOImpl userDAO = UserDAOImpl.getInstance();

    @Override
    public User authorization(String login, String passport) throws ServiceException {
        User user = new User();
        try {
            user = userDAO.getUserByLoginInfo(login, passport);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public void registration(User user) throws ServiceException {
        try {
            userDAO.addUser(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAllUsers() throws ServiceException {
        List<User> userList = new ArrayList<>();
        try {
            userList = userDAO.getUserList();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return userList;
    }

    @Override
    public User getUserById(String id) throws ServiceException {
        User user = new User();
        try {
            user = userDAO.getUserById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public void unblockUser(int idUser) throws ServiceException {
        try {
            userDAO.unblockUser(idUser);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void blockUser(int idUser) throws ServiceException {
        try {
            userDAO.blockUser(idUser);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateUserData(int idUser, String newPasswordString, String newFullnameString, String newPassportString, String newEmailString) throws ServiceException {
        try {
            userDAO.updateUserData(idUser, newPasswordString, newFullnameString, newPassportString, newEmailString);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }


}
