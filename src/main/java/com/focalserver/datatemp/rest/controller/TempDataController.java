package com.focalserver.datatemp.rest.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.focalserver.datatemp.rest.dao.TempDataDAO;
import com.focalserver.datatemp.rest.models.TempData;

@RestController
public class TempDataController {

	@Autowired
	TempDataDAO tempDataDAO;
	
    @RequestMapping(value="/tempdata", method=RequestMethod.POST, consumes = "application/json")
    public boolean tempDataSave(@RequestBody TempData tempData) {
    	
    	tempData.setDateTime(new Timestamp(System.currentTimeMillis()));
    	tempDataDAO.save(tempData);
    	
    	return true;
    }
    
    @RequestMapping(value="/tempdata", method=RequestMethod.GET, produces = "application/json")
    public String tempDataGet(@RequestParam(value="id") Long id) {
    	
    	return tempDataDAO.findOne(id).toString();
    }
}
