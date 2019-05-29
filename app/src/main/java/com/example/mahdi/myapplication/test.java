package com.example.mahdi.myapplication;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) {
//        Date date = new Date();
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Date date1 = new Date();
//        String a = MainAppActivity.getDiffDates(date,date1);
//        System.out.println(a);


        String a[] = new String[3];
        MainAppActivity.times[0]="30";
        MainAppActivity.times[1]="60";
        MainAppActivity.times[2]="10";

        MainAppActivity.viderTimes();
        MainAppActivity.times[0]="30";
        MainAppActivity.times[1]="00";



        System.out.println(MainAppActivity.getMinTime(MainAppActivity.times));

    }
}
