package com.focalserver.datatemp.rest.tos;

/**
 * Created by overlag on 22/01/17.
 */

public final class DayTempsTOPopulator {

    private DayTempsTOPopulator() {
    }

    private static String NO_DATA = "--";

    public static DayTempsTO populate(Long pMinTemp, String pMinTempDate, Long pMaxTemp, String pMaxTempDate) {

        return DayTempsTO.builder() //
        .minTemp(pMinTemp == null ? NO_DATA : pMinTemp.toString()) //
        .minTempDate(pMinTempDate == null ? NO_DATA : pMinTempDate) //
        .maxTemp(pMaxTemp == null ? NO_DATA : pMaxTemp.toString()) //
        .maxTempDate(pMaxTempDate == null ? NO_DATA : pMaxTempDate) //
        .build();
    }
}
