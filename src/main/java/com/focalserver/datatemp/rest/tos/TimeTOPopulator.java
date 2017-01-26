package com.focalserver.datatemp.rest.tos;

import com.focalserver.datatemp.rest.utils.LocalDateTimeUtils;
import org.joda.time.DateTime;

/**
 * Created by arepresas on 11/12/16.
 */
public final class TimeTOPopulator {

    public static TimeTO populate (final DateTime pDateTime) {

        return TimeTO.builder() //
        .hour(pDateTime.getHourOfDay()) //
        .minute(pDateTime.getMinuteOfHour()) //
        .second(pDateTime.getSecondOfMinute()) //
        .day(pDateTime.getDayOfMonth()) //
        .month(pDateTime.getMonthOfYear()) //
        .year(pDateTime.getYear()) //
        .localDateTime(LocalDateTimeUtils.getLocalDateTimeString(pDateTime, null)) //
        .build();
    }
}
