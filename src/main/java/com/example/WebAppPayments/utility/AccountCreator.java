package com.example.WebAppPayments.utility;

import com.example.WebAppPayments.entity.Account;
import com.example.WebAppPayments.entity.Card;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class AccountCreator {

    public static Account createAccount(int id_user, int id_currency){
        Account account = new Account();

        Random random = new Random();
        int acc_number = random.nextInt(9000000) + 1000000;
        String acc_str = "";
        switch (id_currency){
            case 1:{
                acc_str = "BYN";
                break;
            }
            case 2:{
                acc_str = "USD";
                break;
            }
            case 3:{
                acc_str = "EUR";
                break;
            }
        }
        String acc_full_number = acc_str+acc_number;

        account.setId_user(id_user);
        account.setAcc_number(acc_full_number);
        account.setId_currency(id_currency);


        return account;

    }
}
