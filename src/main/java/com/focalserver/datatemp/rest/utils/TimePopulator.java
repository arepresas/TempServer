package com.focalserver.datatemp.rest.utils;

import com.focalserver.datatemp.rest.models.TimeObject;
import org.joda.time.DateTime;

/**
 * Created by overlag on 11/12/16.
 */
public class TimePopulator {

    private final static TimeObject timeObject = new TimeObject();;

    public static TimeObject populate (final DateTime dateTime) {

        timeObject.setDay(dateTime.getDayOfMonth());
        timeObject.setMonth(dateTime.getMonthOfYear());
        timeObject.setYear(dateTime.getYear());
        timeObject.setHour(dateTime.getHourOfDay());
        timeObject.setMinute(dateTime.getMinuteOfHour());
        timeObject.setSecond(dateTime.getSecondOfMinute());

        return timeObject;
    }
}
