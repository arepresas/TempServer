package com.focalserver.datatemp.rest.tos;

import lombok.Builder;
import lombok.Data;

/**
 * Created by arepresas on 11/12/16.
 */
@Builder
@Data
public final class TimeTO {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int second;
    private String localDateTime;
}
