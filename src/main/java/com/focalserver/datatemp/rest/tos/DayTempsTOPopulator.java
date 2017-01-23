package com.focalserver.datatemp.rest.tos;

/**
 * Created by overlag on 22/01/17.
 */

public final class DayTempsTOPopulator {

    private DayTempsTOPopulator() {
    }

    public static DayTempsTO populate(Long pminTemp, Long pmaxTemp) {
        String minTemp = pminTemp==null?"--":pminTemp.toString();
        String maxTemp = pmaxTemp==null?"--":pmaxTemp.toString();

        return new DayTempsTO(minTemp, maxTemp);
    }
}
