package jom.com.softserve.s6.task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class MyUtils {
    public static String getDateAfterToday(int years, int months, int days) {
        var futureDate = LocalDate
                .now()
                .plusYears(years)
                .plusMonths(months)
                .plusDays(days);
        return futureDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
