package com.focalserver.datatemp.rest.controller;

import com.focalserver.datatemp.rest.models.TimeObject;
import com.focalserver.datatemp.rest.utils.TimePopulator;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.TimeZone;

@RestController
public class TimeController {

    @RequestMapping(value="/getTimeNow", method= RequestMethod.GET, produces = "application/json")
    public TimeObject getTimeObjectNow (){

        DateTime dateTime = new DateTime(System.currentTimeMillis());

        return TimePopulator.populate(dateTime.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone("Europe/Paris"))));
    }
}
