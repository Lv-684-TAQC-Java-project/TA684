package com.ita.speakukrainian.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateProvider {

    public String date(){
        LocalDate localDate = LocalDate.now();
        String date = localDate.toString();
        return  date;
    }

    public String dateFuture(){
        LocalDate localDate = LocalDate.now();
        LocalDate localDateFuture = localDate.plusDays(2);
        return   localDateFuture.toString() ;
    }

    public String datePast(){
        LocalDate localDate = LocalDate.now();
        LocalDate localDatePast = localDate.minusDays(1);
        return   localDatePast.toString() ;
    }

}
