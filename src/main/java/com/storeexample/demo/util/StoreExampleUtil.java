package com.storeexample.demo.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StoreExampleUtil {

    private final static Pattern REQUEST_DYNAMIC_FILTER = Pattern.compile(
            "(\\w+?\\.?\\w+?)([:><])(\\w+?|\\d\\d\\d\\d-\\d\\d-\\d\\d),");

    public static Matcher getRequestDynamicFilterMatcher(String search) {
        // TODO fix for cyrillic letters
        return REQUEST_DYNAMIC_FILTER.matcher(search + ",");
    }

    public static ZonedDateTime convertDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate localDate = LocalDate.parse(date, formatter);
        return ZonedDateTime.of(localDate, LocalTime.MIN, ZoneId.systemDefault());
    }
}
