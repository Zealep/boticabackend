package com.zealep.api.salesbackend.util;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate pastWeek = localDate.minusWeeks(1);
        System.out.println(pastWeek);
    }
}
