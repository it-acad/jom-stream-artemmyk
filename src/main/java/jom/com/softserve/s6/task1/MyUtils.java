package jom.com.softserve.s6.task1;

import java.time.LocalDate;

public class MyUtils {

    public static boolean isLeapYear(int year) {
        var date = LocalDate.ofYearDay(year, 1);
        return date.isLeapYear();
    }

}
