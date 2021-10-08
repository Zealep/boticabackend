package com.zealep.api.salesbackend.util;

import org.springframework.format.datetime.DateFormatter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String convertDateToStringFormatddMMyyyy(LocalDate date){
        try {
            if(date!=null){
               return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }else {
                return null;
            }
        }catch (Exception ex){
            System.out.println(ex);
            return null;
        }

        }
}
