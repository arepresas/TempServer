package com.focalserver.datatemp.rest.models;

import lombok.Data;

/**
 * Created by arepresas on 11/12/16.
 */
public @Data class TimeObject {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int second;
    private String localDateTime;
}
