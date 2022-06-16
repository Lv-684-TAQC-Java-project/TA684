package com.ita.speakukrainian.utils;

import java.time.LocalDate;
import java.util.Date;

public class DateProvider {

    public String date(){
        LocalDate localDate = LocalDate.now();
        String date = localDate.toString();
        return  date;
    }

}
