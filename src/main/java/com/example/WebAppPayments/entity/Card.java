package com.example.WebAppPayments.entity;

import java.io.Serializable;
import java.util.Objects;

public class Card implements Serializable {

    private int id;
    private int id_account;
    private String number;
    private int cvv_code;
    private String valid_date;

    public Card() {
    }

    public Card(int id, int id_account, String number, int cvv_code, String valid_date) {
        this.id = id;
        this.id_account = id_account;
        this.number = number;
        this.cvv_code = cvv_code;
        this.valid_date = valid_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCvv_code() {
        return cvv_code;
    }

    public void setCvv_code(int cvv_code) {
        this.cvv_code = cvv_code;
    }

    public String getValid_date() {
        return valid_date;
    }

    public void setValid_date(String valid_date) {
        this.valid_date = valid_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id == card.id && id_account == card.id_account && cvv_code == card.cvv_code && number.equals(card.number) && valid_date.equals(card.valid_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_account, number, cvv_code, valid_date);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", id_account=" + id_account +
                ", number='" + number + '\'' +
                ", cvv_code=" + cvv_code +
                ", valid_date='" + valid_date + '\'' +
                '}';
    }
}
