package com.focalserver.datatemp.rest.dao;

import com.focalserver.datatemp.rest.models.TempObject;

import java.util.List;

/**
 * Created by arepresas on 11/01/17.
 */
public interface TempObjectCustomDAO {

    List<TempObject> localDateTime(String date12);

}
