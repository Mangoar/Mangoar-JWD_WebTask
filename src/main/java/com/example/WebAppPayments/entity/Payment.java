package com.example.WebAppPayments.entity;

import java.io.Serializable;
import java.util.Objects;

public class Payment implements Serializable {

    private int id;
    private int id_card;
    private String payment_date;
    private int id_type;
    private double sum;
    private String destination;

    public Payment() {
    }

    public Payment(int id, int id_card, String payment_date, int id_type, double sum, String destination) {
        this.id = id;
        this.id_card = id_card;
        this.payment_date = payment_date;
        this.id_type = id_type;
        this.sum = sum;
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id && id_card == payment.id_card && id_type == payment.id_type && Double.compare(payment.sum, sum) == 0 && payment_date.equals(payment.payment_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_card, payment_date, id_type, sum);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", id_card=" + id_card +
                ", payment_date='" + payment_date + '\'' +
                ", id_type=" + id_type +
                ", sum=" + sum +
                ", destination='" + destination + '\'' +
                '}';
    }
}
