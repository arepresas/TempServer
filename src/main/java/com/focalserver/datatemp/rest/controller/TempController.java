package com.focalserver.datatemp.rest.controller;

import com.focalserver.datatemp.rest.dao.TempObjectDAO;
import com.focalserver.datatemp.rest.models.TempObject;
import com.focalserver.datatemp.rest.tos.DayTempsTO;
import com.focalserver.datatemp.rest.tos.DayTempsTOPopulator;
import com.focalserver.datatemp.rest.utils.LocalDateTimeUtils;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController {

	@Autowired
    TempObjectDAO tempObjectDAO;

    /**
     * Save TemObject in DB
     *
     * @param tempObject
     * @return
     */
    @RequestMapping(value="/tempdata", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Long saveTempObject(@RequestBody TempObject tempObject) {

        Timestamp dateTimeNow = new Timestamp(System.currentTimeMillis());

    	tempObject.setDateTime(dateTimeNow);
    	tempObject.setLocalDateTime(LocalDateTimeUtils.getLocalDateTimeString());
    	return tempObjectDAO.save(tempObject).getDataId();
    }

    /**
     * Get TempObject by ID
     *
     * @param id
     * @return
     */
    @RequestMapping(value="/tempdata", method=RequestMethod.GET, produces = "application/json")
    public TempObject getTempObject(@RequestParam(value="id") Long id) {
    	
    	return tempObjectDAO.findOne(id);
    }

    /**
     * Get DayTempsTO with min and max temperature for today
     *
     * @return
     */
    @RequestMapping(value="/getMaxMinTemp", method=RequestMethod.GET, produces = "application/json")
    public DayTempsTO getTodayMinMaxTemp() {

        List<TempObject> tempObjects = tempObjectDAO.findByLocalDateTimeContainingOrderByDataIdDesc(LocalDateTimeUtils.getCurrentDate());

        return getMaxMinDayTempsTO(tempObjects);
    }

    /**
     * Get last temperature in DB
     *
     * @return
     */
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