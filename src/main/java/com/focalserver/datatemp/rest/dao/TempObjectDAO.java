package com.focalserver.datatemp.rest.dao;

import org.springframework.data.repository.CrudRepository;
import com.focalserver.datatemp.rest.models.TempObject;

public interface TempObjectDAO extends CrudRepository<TempObject, Long>, TempObjectCustomDAO{

}
