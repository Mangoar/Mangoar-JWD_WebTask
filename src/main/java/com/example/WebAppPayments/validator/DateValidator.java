package com.example.WebAppPayments.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {

    private DateValidator(){};

    public static boolean isBeforeToday(String date1, String date2){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateToCompare = sdf.parse(date1);
            Date dateCompared = sdf.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = date1.compareTo(date2);

        return result < 0;

    }

    public static boolean isAfterToday(String date1, String date2){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateToCompare = sdf.parse(date1);
            Date dateCompared = sdf.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = date1.compareTo(date2);

        return result > 0;
    }

    public static boolean isToday(String date1, String date2){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateToCompare = sdf.parse(date1);
            Date dateCompared = sdf.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = date1.compareTo(date2);

        return result == 0;
    }

//    public static boolean isThreeYearsMore(String date1){
//
//    }
//
//    public static boolean isEigtheenYearsLess(String date1){
//
//    }
}
