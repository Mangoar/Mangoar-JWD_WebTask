package com.example.WebAppPayments.connection;

import com.example.WebAppPayments.exception.ConnectionPoolException;

public class ConnectionProvider {

    private static ConnectionPool instance;

    public static void getConnectionPool() {
//        if (instance == null) {
//            try {
//                instance = new ConnectionPool();
//            } catch (ConnectionPoolException e) {
//                e.printStackTrace();
//            }
//        }
//        return instance;
    }

    private ConnectionProvider(){}

}
