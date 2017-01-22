package com.focalserver.datatemp.rest.utils;

import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 * Created by arepresas on 8/01/17.
 */
public final class LocalDateTimeUtils {

    private static final String PATTERN = "HH:mm dd/MM/yy";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    public static String getLocalDateTimeString(Timestamp dateTime) {
        return dateTime.toLocalDateTime().format(DATE_TIME_FORMATTER).toString();
    }

    public static String getLocalDateTimeString(DateTime dateTime) {

        return dateTime.toLocalDateTime().toString(PATTERN);
    }

}
