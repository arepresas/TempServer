package com.focalserver.datatemp.rest.utils;

import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 * Created by arepresas on 8/01/17.
 */
public final class LocalDateTimeUtils {

    private LocalDateTimeUtils() {
    }

    private static final String DATE_TIME_PATTERN = "HH:mm dd/MM/yy";
    private static final String DATE_PATTERN = "dd/MM/yy";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    public static String getLocalDateTimeString(Timestamp dateTime) {
        return dateTime.toLocalDateTime().format(DATE_TIME_FORMATTER).toString();
    }

    public static String getLocalDateTimeString(DateTime dateTime, String pattern) {

        return dateTime.toLocalDateTime().toString(pattern==null?DATE_TIME_PATTERN:pattern);
    }

    public static String getCurrentDate() {
        return getLocalDateTimeString(new DateTime(System.currentTimeMillis()), DATE_PATTERN);
    }

}
