package com.focalserver.datatemp.rest.controller;

import java.sql.Timestamp;

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
    public Boolean saveTempObject(@RequestBody TempObject tempObject) {
    	
    	tempObject.setDateTime(new Timestamp(System.currentTimeMillis()));
    	return tempObject == tempObjectDAO.save(tempObject);
    }
    
    @RequestMapping(value="/tempdata", method=RequestMethod.GET, produces = "application/json")
    public TempObject getTempObject(@RequestParam(value="id") Long id) {
    	
    	return tempObjectDAO.findOne(id);
    }
}
