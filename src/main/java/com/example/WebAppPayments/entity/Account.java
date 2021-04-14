package com.example.WebAppPayments.entity;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {

    private int id;
    private int id_user;
    private String acc_number;
    private double balance;
    private int id_currency;

    public Account() {
    }

    public Account(int id, String acc_number, double balance, int id_currency) {
        this.id = id;
        this.acc_number = acc_number;
        this.balance = balance;
        this.id_currency = id_currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getAcc_number() {
        return acc_number;
    }

    public void setAcc_number(String acc_number) {
        this.acc_number = acc_number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId_currency() {
        return id_currency;
    }

    public void setId_currency(int id_currency) {
        this.id_currency = id_currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && id_user == account.id_user && Double.compare(account.balance, balance) == 0 && id_currency == account.id_currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_user, balance, id_currency);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", acc_number='" + acc_number + '\'' +
                ", balance=" + balance +
                ", id_currency=" + id_currency +
                '}';
    }
}
