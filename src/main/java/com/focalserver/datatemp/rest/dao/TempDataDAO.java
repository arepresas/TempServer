package com.focalserver.datatemp.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.focalserver.datatemp.rest.models.TempData;

public interface TempDataDAO extends CrudRepository<TempData, Long>{

}
