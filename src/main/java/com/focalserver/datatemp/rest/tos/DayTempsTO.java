package com.focalserver.datatemp.rest.tos;

import lombok.Builder;
import lombok.Data;

/**
 * Created by arepresas on 22/01/17.
 */

@Data
@Builder
public final class DayTempsTO {

    private String minTemp;
    private String maxTemp;
}
