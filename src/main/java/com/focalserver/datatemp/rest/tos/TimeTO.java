package com.focalserver.datatemp.rest.tos;

import lombok.Builder;

/**
 * Created by arepresas on 11/12/16.
 */
@Builder
public final class TimeTO {

    private TimeTO() {
    }

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int second;
    private String localDateTime;
}
