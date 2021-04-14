package com.example.WebAppPayments.dao.impl;

import com.example.WebAppPayments.connection.ConnectionPool;
import com.example.WebAppPayments.connection.ConnectionProvider;
import com.example.WebAppPayments.dao.PaymentDAO;
import com.example.WebAppPayments.entity.Payment;
import com.example.WebAppPayments.exception.ConnectionPoolException;
import com.example.WebAppPayments.exception.DaoException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

    private static final String ADD_PAYMENT = "INSERT INTO PAYMENT (id_card, payment_date, id_type, sum, destination)" +
            " VALUES (?,now(),?,?,?);";

    private static final String SELECT_PAYMENTLIST_BY_ACC_ID = "SELECT * FROM payment where id_card in (select id from cards where id_account in (select id from account where id_user = ?)) order by payment_date desc limit 15;";
    private static final String SELECT_YEARPAYMENTLIST_BY_ACC_ID = "SELECT * FROM payment where id_card in (select id from cards where id_account in (select id from account where id_user = ?)) and YEAR(payment_date) = YEAR(CURDATE());";
    private static final String SELECT_WEEKPAYMENTLIST_BY_ACC_ID = "SELECT * FROM payment where id_card in (select id from cards where id_account in (select id from account where id_user = ?)) and WEEK(payment_date) = WEEK(CURDATE());";
    private static final String SELECT_MONTHPAYMENTLIST_BY_ACC_ID = "SELECT * FROM payment where id_card in (select id from cards where id_account in (select id from account where id_user = ?)) and MONTH(payment_date) = MONTH(CURDATE());";
    private static final String SELECT_NOWPAYMENTLIST_BY_ACC_ID = "SELECT * FROM payment where id_card in (select id from cards where id_account in (select id from account where id_user = ?)) order by payment_date desc limit 1;";



    private static final Logger logger = Logger.getLogger(PaymentDAOImpl.class);

    private static final PaymentDAOImpl instance = new PaymentDAOImpl();

    private PaymentDAOImpl() {
    }

    public static PaymentDAOImpl getInstance() {
        return instance;
    }

    @Override
    public void addPayment(Payment payment) throws DaoException {
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            Connection connection = pool.takeConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_PAYMENT);
            preparedStatement.setInt(1, payment.getId_card());
            preparedStatement.setInt(2, payment.getId_type());
            preparedStatement.setDouble(3, payment.getSum());
            preparedStatement.setString(4, payment.getDestination());
            preparedStatement.executeUpdate();
            pool.releaseConnection(connection);
        } catch (SQLException ex) {
            throw new DaoException("Problem with connection to DB occured!",ex);
        } catch (ConnectionPoolException e) {
            throw new DaoException("Problem with connection pool occured!",e);
        }
    }

    @Override
    public List<Payment> getPaymentList(int user_id) throws DaoException {
        ConnectionPool pool = ConnectionPool.getInstance();
        List<Payment> paymentList = new ArrayList<>();
        try {
            Connection connection = pool.takeConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SELECT_PAYMENTLIST_BY_ACC_ID);
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            paymentList = getPaymentInfo(resultSet);
            pool.releaseConnection(connection);
        } catch (SQLException ex) {
            throw new DaoException("Problem with connection to DB occured!",ex);
        } catch (ConnectionPoolException e) {
            throw new DaoException("Problem with connection pool occured!",e);
        }
        return paymentList;
    }

    @Override
    public List<Payment> getYearPaymentList(int user_id) throws DaoException {
        ConnectionPool pool = ConnectionPool.getInstance();
        List<Payment> paymentList = new ArrayList<>();
        try {
            Connection connection = pool.takeConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SELECT_YEARPAYMENTLIST_BY_ACC_ID);
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            paymentList = getPaymentInfo(resultSet);
            pool.releaseConnection(connection);
        } catch (SQLException ex) {
            throw new DaoException("Problem with connection to DB occured!",ex);
        } catch (ConnectionPoolException e) {
            throw new DaoException("Problem with connection pool occured!",e);
        }
        return paymentList;
    }

    @Override
    public List<Payment> getMonthPaymentList(int user_id) throws DaoException {
        ConnectionPool pool = ConnectionPool.getInstance();
        List<Payment> paymentList = new ArrayList<>();
        try {
            Connection connection = pool.takeConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SELECT_MONTHPAYMENTLIST_BY_ACC_ID);
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            paymentList = getPaymentInfo(resultSet);
            pool.releaseConnection(connection);
        } catch (SQLException ex) {
            throw new DaoException("Problem with connection to DB occured!",ex);
        } catch (ConnectionPoolException e) {
            throw new DaoException("Problem with connection pool occured!",e);
        }
        return paymentList;
    }

    @Override
    public List<Payment> getWeekPaymentList(int user_id) throws DaoException {
        ConnectionPool pool = ConnectionPool.getInstance();
        List<Payment> paymentList = new ArrayList<>();
        try {
            Connection connection = pool.takeConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SELECT_WEEKPAYMENTLIST_BY_ACC_ID);
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            paymentList = getPaymentInfo(resultSet);
            pool.releaseConnection(connection);
        } catch (SQLException ex) {
            throw new DaoException("Problem with connection to DB occured!",ex);
        } catch (ConnectionPoolException e) {
            throw new DaoException("Problem with connection pool occured!",e);
        }
        return paymentList;
    }

    @Override
    public List<Payment> getLastPaymentList(int user_id) throws DaoException {
        ConnectionPool pool = ConnectionPool.getInstance();
        List<Payment> paymentList = new ArrayList<>();
        try {
            Connection connection = pool.takeConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SELECT_NOWPAYMENTLIST_BY_ACC_ID);
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            paymentList = getPaymentInfo(resultSet);
            pool.releaseConnection(connection);
        } catch (SQLException ex) {
            throw new DaoException("Problem with connection to DB occured!",ex);
        } catch (ConnectionPoolException e) {
            throw new DaoException("Problem with connection pool occured!",e);
        }
        return paymentList;
    }

    private List<Payment> getPaymentInfo(ResultSet resultSet) throws SQLException {
        List<Payment> paymentList = new ArrayList<>();
        Payment paymentInfo;
        while(resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(1));
            int id_card = Integer.parseInt(resultSet.getString(2));
            String date = resultSet.getString(3);
            int id_type = Integer.parseInt(resultSet.getString(4));
            double sum = Double.parseDouble(resultSet.getString(5));
            String destination = resultSet.getString(6);
            paymentInfo = new Payment(id, id_card, date, id_type, sum,destination);
            paymentList.add(paymentInfo);
        }
        return paymentList;
    }
}
