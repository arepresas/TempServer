package com.focalserver.datatemp.rest.tos;

import lombok.Data;

/**
 * Created by arepresas on 22/01/17.
 */

@Data
public class DayTempsTO {
    private String minTemp;
    private String maxTemp;

    public DayTempsTO(String minTemp, String maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }
}
