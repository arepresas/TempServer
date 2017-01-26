package com.focalserver.datatemp.rest.tos;

/**
 * Created by overlag on 22/01/17.
 */

public final class DayTempsTOPopulator {

    private DayTempsTOPopulator() {
    }

    private static String NO_DATA = "--";

    public static DayTempsTO populate(Long pminTemp, Long pmaxTemp) {

        return DayTempsTO.builder() //
        .minTemp(pminTemp == null ? NO_DATA : pminTemp.toString()) //
        .maxTemp(pmaxTemp == null ? NO_DATA : pmaxTemp.toString()) //
        .build();
    }
}
