package com.example.WebAppPayments.utility;

import com.example.WebAppPayments.entity.Card;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class CardCreator {

    private CardCreator(){};

    public static Card createCard(int id_account){
        Card card = new Card();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now() ;
        String valid_date = dtf.format(now.plusYears(1));

        Random random = new Random();
        int cvv = random.nextInt(900) + 100;

        int number1 = random.nextInt(9000) + 1000;
        int number2 = random.nextInt(9000) + 1000;
        int number3 = random.nextInt(9000) + 1000;
        int number4 = random.nextInt(9000) + 1000;
        String str_number = ""+number1+number2+number3+number4;

        card.setId_account(id_account);
        card.setCvv_code(cvv);
        card.setNumber(str_number);
        card.setValid_date(valid_date);


        return card;

    }
}
