/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumaga.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author vertec-r
 */
public class test {

    public static void main(String[] args) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        String inputString1 = "2016-12-25";
        String inputString2 = "2017-01-14";

        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
//            long diff = date2.getTime() - date1.getTime();
//            System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            
            if (date2.before(date1)) {
                System.out.println("Late Apoint");
            }else{
                System.out.println("Clear");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
