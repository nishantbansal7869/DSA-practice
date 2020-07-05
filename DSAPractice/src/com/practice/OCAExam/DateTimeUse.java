package com.practice.OCAExam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class DateTimeUse {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        LocalDate date = LocalDate.of(2020,9,18);
        String s = formatter.format(date);
        System.out.print(s);
    }
}
