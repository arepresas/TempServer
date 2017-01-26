package com.focalserver.datatemp.rest.controller;

import com.focalserver.datatemp.rest.tos.TimeTO;
import com.focalserver.datatemp.rest.tos.TimeTOPopulator;
import com.focalserver.datatemp.rest.utils.LocalDateTimeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    /**
     * Get TimeTO with current date and time
     *
     * @return
     */
    @RequestMapping(value="/getTimeNow", method= RequestMethod.GET, produces = "application/json")
    public TimeTO getTimeObjectNow (){

        return TimeTOPopulator.populate(LocalDateTimeUtils.toLocalDateTime());
    }
}
