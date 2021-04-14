package com.example.WebAppPayments.dao;

import com.example.WebAppPayments.connection.ConnectionPool;
import com.example.WebAppPayments.connection.ConnectionProvider;
import com.example.WebAppPayments.controller.command.impl.Login;
import com.example.WebAppPayments.dao.impl.AccountDAOImpl;
import com.example.WebAppPayments.dao.impl.PaymentDAOImpl;
import com.example.WebAppPayments.entity.Payment;
import com.example.WebAppPayments.exception.ConnectionPoolException;
import com.example.WebAppPayments.exception.DaoException;
import com.example.WebAppPayments.exception.TransactionException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class Transaction {

    private static final Logger logger = Logger.getLogger(Transaction.class);

    private static final Transaction instance = new Transaction();

    private Transaction(){
    }

    public static Transaction getInstance() {
        return instance;
    }

    private static final AccountDAOImpl accountDAO = AccountDAOImpl.getInstance();
    private static final PaymentDAOImpl paymentDAO = PaymentDAOImpl.getInstance();

    public void newPayment(int id_account, double newValue, Payment payment) throws TransactionException {

        Connection connection = null;
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            connection.setAutoCommit(false);
            accountDAO.updateBalance(id_account, newValue);
            paymentDAO.addPayment(payment);
        }catch (SQLException | DaoException | ConnectionPoolException e) {
            rollbackConnection(connection);
            throw new TransactionException("Can't proceed payment", e);
        } finally {
            closeConnection(connection);
        }

    }

    private void rollbackConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch (SQLException e) {
            logger.error("Error while rollback transaction: ", e);
        }
    }

    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                logger.error("Error while closing connection: ", e);
            }
        }
    }


}