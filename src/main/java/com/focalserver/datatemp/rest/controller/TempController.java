package com.focalserver.datatemp.rest.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.focalserver.datatemp.rest.tos.DayTempsTO;
import com.focalserver.datatemp.rest.tos.DayTempsTOPopulator;
import com.focalserver.datatemp.rest.utils.LocalDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.focalserver.datatemp.rest.dao.TempObjectDAO;
import com.focalserver.datatemp.rest.models.TempObject;

@RestController
public class TempController {

	@Autowired
    TempObjectDAO tempObjectDAO;

    @RequestMapping(value="/tempdata", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Long saveTempObject(@RequestBody TempObject tempObject) {

        Timestamp dateTimeNow = new Timestamp(System.currentTimeMillis());

    	tempObject.setDateTime(dateTimeNow);
    	tempObject.setLocalDateTime(LocalDateTimeUtils.getLocalDateTimeString(dateTimeNow));
    	return tempObjectDAO.save(tempObject).getDataId();
    }
    
    @RequestMapping(value="/tempdata", method=RequestMethod.GET, produces = "application/json")
    public TempObject getTempObject(@RequestParam(value="id") Long id) {
    	
    	return tempObjectDAO.findOne(id);
    }

    @RequestMapping(value="/getMaxMinTemp", method=RequestMethod.GET, produces = "application/json")
    public DayTempsTO getTodayMinMaxTemp() {

        List<TempObject> tempObjects = tempObjectDAO.findByLocalDateTimeContainingOrderByDataIdDesc(LocalDateTimeUtils.getCurrentDate());

        return getMaxMinDayTempsTO(tempObjects);
    }

    @RequestMapping(value="/getLastTemp", method=RequestMethod.GET, produces = "application/json")
    public TempObject getLastTempObject() {

        Long lastId = tempObjectDAO.count();

        return tempObjectDAO.findOne(lastId);
    }

    private DayTempsTO getMaxMinDayTempsTO(List<TempObject> tempObjects) {

        Long minTemp = null;
        Long maxTemp = null;

        for (TempObject tempObject : tempObjects) {
            if (minTemp == null || minTemp > tempObject.getTemperature()) {
                minTemp = tempObject.getTemperature();
            }
            if (maxTemp == null || maxTemp < tempObject.getTemperature()) {
                maxTemp = tempObject.getTemperature();
            }
        }

        return DayTempsTOPopulator.populate(minTemp, maxTemp);
    }

}