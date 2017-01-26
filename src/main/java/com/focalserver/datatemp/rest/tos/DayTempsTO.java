package com.focalserver.datatemp.rest.tos;

import lombok.Builder;

/**
 * Created by arepresas on 22/01/17.
 */

@Builder
public final class DayTempsTO {
    private String minTemp;
    private String maxTemp;

    private DayTempsTO() {
    }
}
