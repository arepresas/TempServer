package com.focalserver.datatemp.rest.utils;

import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * Created by arepresas on 8/01/17.
 */
public final class LocalDateTimeUtils {

    private LocalDateTimeUtils() {
    }

    private static final String DATE_TIME_PATTERN = "HH:mm dd/MM/yy";
    private static final String DATE_PATTERN = "dd/MM/yy";
    private static final String LOCAL_TIME_ZONE = "Europe/Paris";

    public static String getLocalDateTimeString() {
        return getLocalDateTimeString(null , null);
    }

    public static String getCurrentDate() {
        return getLocalDateTimeString(null, DATE_PATTERN);
    }

    public static String getLocalDateTimeString(DateTime pDateTime, String pPattern) {

        return toLocalDateTime(pDateTime).toString(pPattern == null ? DATE_TIME_PATTERN : pPattern);
    }

    public static DateTime toLocalDateTime() {
        return toLocalDateTime(null);
    }

    public static DateTime toLocalDateTime(DateTime pDateTime) {

        pDateTime = pDateTime == null ? new DateTime(System.currentTimeMillis()) : pDateTime;

        return pDateTime.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone(LOCAL_TIME_ZONE)));
    }
}